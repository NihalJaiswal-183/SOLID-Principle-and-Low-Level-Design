package LLDSnakeAndLadder.Model;

import java.util.*;

public class Game{
    Deque<Player> playersList;
    Board board;
    Dice dice;
    Player winner;
    
    public Game(){
        playersList = new LinkedList<>();
        initliazePlayers();
        initliazeBoardAndDice();
        winner = null;
    }

    public void initliazePlayers(){
        Player player1 = new Player("Alice", "p1");
        Player player2 = new Player("Bob", "p2");
        playersList.add(player1);
        playersList.add(player2);
    }

    private void initliazeBoardAndDice() {
        board = new Board(10, 5,4);
        dice = new Dice(1);
    }

    public void startGame(){

        while(winner == null){
            Player playerTurn = findPlayerTurn();
            System.out.println("player turn is:" + playerTurn.id + " current position is: " + playerTurn.playerCurrentPos);

            int diceNumbers = dice.rollDice();

            int playerNewPosition = playerTurn.playerCurrentPos + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.playerCurrentPos = playerNewPosition;

            System.out.println("player turn is:" + playerTurn.id + " new Position is: " + playerNewPosition);
            if(playerNewPosition >= board.cells.length * board.cells.length-1){
                winner = playerTurn;
                System.out.println( playerTurn.name + " is the winner");
            }
        }
    }


    private Player findPlayerTurn() {

        Player playerTurns = playersList.removeFirst();
        playersList.addLast(playerTurns);
        return playerTurns;
    }

    private int jumpCheck (int playerNewPosition) {

        if(playerNewPosition > board.cells.length * board.cells.length-1 ){
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if(cell.isCellHaveJump == true && cell.jump.start == playerNewPosition) {
            String jumpBy = (cell.jump.start < cell.jump.end)? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }

}