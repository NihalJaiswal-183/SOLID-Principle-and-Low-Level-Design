package LLDChessGame;

import java.util.Scanner;

import LLDChessGame.Model.Board;
import LLDChessGame.Model.Cell;
import LLDChessGame.Model.GameStatus;
import LLDChessGame.Model.Player;

class Game{
    private Player[] players;
    private Board board;
    private Player currentPlayer;
    private GameStatus status;
    // private List<Move> movesPlayed;

    public Game(Board board){
        this.board = board;
        this.status = GameStatus.ACTIVE;
        players = new Player[2];
        players[0] = new Player("player 1", true);
        players[1] = new Player("player 2", false);
    }

    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        currentPlayer = getWhiteSidePlayer();

        while(status == GameStatus.ACTIVE){
            board.display();
            System.out.println("current player "+ currentPlayer.getPlayerName());
            System.out.print("Enter your move (e.g., 'e2 e4'): ");
            String move = scanner.nextLine().trim().toLowerCase();

            if (move.equals("exit")) {
                break;
            }

            if(board.isValidMove(currentPlayer, move)){
                board.makeMove(move);
                if (board.isGameEnd(players[0], players[1])) {
                    board.display();
                    System.out.println("Game Over!");
                    Player winner = determineWinner();
                    if (winner != null) {
                        System.out.println("Player " + winner + " wins!");
                    } else {
                        System.out.println("The game ended in a draw.");
                    }
                    break;
                }
                currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
            }
            else{
                System.out.println("Invalid Move");
            }
         
        }

    }

    public GameStatus getStatus() {
        return this.status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    private Player getWhiteSidePlayer(){
        if(players[0].isWhiteSide()){
            return players[0];
        }
        return players[1];
    }

    private Player determineWinner() {
        // Determine the winner based on the captured kings
        if (!board.isKingAlive(players[0])) {
            return players[1];
        } else if (!board.isKingAlive(players[1])) {
            return players[0];
        } else {
            // If both kings are alive, it's a draw if no player has any legal moves
            return null;
        }
    }
   
}
