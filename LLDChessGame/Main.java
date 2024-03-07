package LLDChessGame;

import LLDChessGame.Model.Board;

public class Main {
    public static void main(String[] args) {
        Board chessBoard = new Board();
        Game chessGame = new Game(chessBoard);
        chessGame.startGame();
    }
}