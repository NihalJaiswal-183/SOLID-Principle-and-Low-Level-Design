package LLDChessGame.Model;

public class Knight extends Piece{

    public Knight(boolean isWhitePiece){
        super(isWhitePiece);
    }

    public boolean canMove(Cell startCell, Cell endCell){
        return (Math.abs(startCell.getXCordinate() - endCell.getXCordinate()) == 2 && Math.abs(startCell.getYCordinate() - endCell.getYCordinate()) == 1) ||
        (Math.abs(startCell.getXCordinate() - endCell.getXCordinate()) == 1 && Math.abs(startCell.getYCordinate() - endCell.getYCordinate()) == 2);
    }
}