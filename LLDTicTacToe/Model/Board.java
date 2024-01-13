package LLDTicTacToe.Model;
import java.util.AbstractMap;

import java.util.ArrayList;
import java.util.List;

public class Board{

    public int size;
    public PlayingEntity[][] board;

    public Board(int size){
        this.size = size;
        board = new PlayingEntity[size][size];
    }

    public boolean addPiece(int row, int col, PlayingEntity playingEntity){
        if(row > size || col > size || this.board[row][col] != null){
            return false;
        }
        this.board[row][col] = playingEntity;
        return true;
    }

    public void printBoard(){

        for(int row=0;row<board.length;row++){
            for(int col=0;col < board[row].length; col++){
                if(board[row][col] != null){
                    System.out.print(board[row][col].name() + "|");
                }
                else{
                    System.out.print(" " + "|");
                }
            }
            System.out.println();
        }
    }

    public List<AbstractMap.SimpleEntry<Integer, Integer>> getFreeCells() {
        List<AbstractMap.SimpleEntry<Integer, Integer>> freeCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    AbstractMap.SimpleEntry<Integer, Integer> rowColumn = new AbstractMap.SimpleEntry<>(i, j);
                    freeCells.add(rowColumn);
                }
            }
        }

        return freeCells;
    }

}