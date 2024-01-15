package LLDTicTacToe;
import java.util.*;

import LLDTicTacToe.Model.Board;
import LLDTicTacToe.Model.Player;
import LLDTicTacToe.Model.PlayerFactory;
import LLDTicTacToe.Model.PlayingEntity;

class TicTacToeGame{
    Deque<Player> players;
    Board gameBoard;
    private Scanner scanner;

    public void initialiseGame(){
        players = new LinkedList<>();
        scanner = new Scanner(System.in);
        setPlayers();
        gameBoard = new Board(3);

    }

    private void setPlayers(){
        int noOfPlayers = 2; 
        for(int playerCount=1; playerCount<=noOfPlayers; playerCount++){
            System.out.println("Enter Player no" + playerCount + " Name");
            String playerName = scanner.nextLine();
            String playerEntityType = getPlayerEntityInput();
            PlayerFactory playerFactoryObj = new PlayerFactory();
            Player player = playerFactoryObj.getPlayerInstance(playerName, playerEntityType);
            this.players.addLast(player);
        }        
    }

    private String getPlayerEntityInput(){
        String playerEntityType;
        Boolean isInputCompleted = true;
        do {
            System.out.println("Enter player playing Entity type (X, O, ...)");
            playerEntityType = scanner.nextLine();
    
            try {
                PlayingEntity.valueOf(playerEntityType.toUpperCase());
                isInputCompleted = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid playing entity type. Please enter 'X' or 'O'.");
                isInputCompleted = false;
            }
        } while (!isInputCompleted);
    
        return playerEntityType.toUpperCase();
    }

    public void startGame(){
        Boolean isGameEnded = false;
        while(isGameEnded == false){
            gameBoard.printBoard();
            List<AbstractMap.SimpleEntry<Integer, Integer>> freeSpaces =  gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()) {
                isGameEnded = true;
                System.out.println("tie");
                continue;
            }
            Player playerTurn = this.players.removeFirst();
            System.out.print("Player:" + playerTurn.name + " Enter row,column: ");
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