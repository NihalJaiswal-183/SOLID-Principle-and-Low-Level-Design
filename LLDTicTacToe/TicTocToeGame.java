package LLDTicTacToe;
import java.util.*;

import LLDTicTacToe.Model.Board;
import LLDTicTacToe.Model.Player;
import LLDTicTacToe.Model.PlayingEntity;

class TicTacToeGame{
    Deque<Player> players;
    Board gameBoard;

    public void initialiseGame(){
        players = new LinkedList<>();
        setPlayers();
        gameBoard = new Board(3);
    }

    private void setPlayers(){
        System.out.print("Enter the no of players");
        Scanner scanner = new Scanner(System.in);

        int noOfPlayers = scanner.nextInt(); 
        scanner.nextLine();

        for(int playerCount=1; playerCount<=noOfPlayers; playerCount++){
            System.out.println("Enter Player no" + playerCount + " Name");
            String playerName = scanner.nextLine();

            System.out.println("Enter player playing Entity type");
            // i need to add validation of chosen option will implement later on
            String playerEntityType = scanner.nextLine();
            Player player;
            if(playerEntityType.equals("X")){
                player = new Player(playerName, PlayingEntity.X);
            }
            else{
                player = new Player(playerName, PlayingEntity.O);
            }
            this.players.addLast(player);
        }        
    }

    public void startGame(){
        Boolean isGameEnded = false;
        Scanner scanner = new Scanner(System.in);
        while(isGameEnded == false){
            gameBoard.printBoard();
            List<AbstractMap.SimpleEntry<Integer, Integer>> freeSpaces =  gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()) {
                isGameEnded = true;
                System.out.println("tie");
                continue;
            }
            Player playerTurn = this.players.removeFirst();
            System.out.print("Player:" + playerTurn.name + " Enter row,column: "+ playerTurn.playingEntity);
            String input = scanner.nextLine();
            String[] coOrdinates = input.split(",");
            // NEEDED TO ADD VALIDATIONS FOR INPUT AS WELL
            int row = Integer.valueOf(coOrdinates[0]);
            int col = Integer.valueOf(coOrdinates[1]);
            Boolean isAddedSuccessfully = gameBoard.addPiece(row, col, playerTurn.playingEntity);
            if(isAddedSuccessfully){
                Boolean isCurrentPlayerWinner = isThereWinner(row, col, playerTurn.playingEntity);
                if(isCurrentPlayerWinner){
                    System.out.println(playerTurn.name + "is the winner");
                    isGameEnded = true;
                }
                players.addLast(playerTurn);
            }
            else{
                System.out.println("Incorred possition chosen, try again");
                players.addFirst(playerTurn);
            } 
        }
        // scanner.close();
    }

    public boolean isThereWinner(int row, int column, PlayingEntity playingEntity) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[row][i] == null || gameBoard.board[row][i] != playingEntity) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[i][column] == null || gameBoard.board[i][column] != playingEntity) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<gameBoard.size;i++,j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j] != playingEntity) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=gameBoard.size-1; i<gameBoard.size;i++,j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j] != playingEntity) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }



}