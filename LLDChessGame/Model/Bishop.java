package LLDChessGame.Model;

public class Bishop extends Piece{
    public Bishop(boolean isWhitePiece){
        super(isWhitePiece);
    }

    @Override
    public boolean canMove(Cell startCell, Cell endCell) {
        return Math.abs(startCell.getXCordinate() - endCell.getXCordinate())
         == 
         Math.abs(startCell.getYCordinate() - endCell.getYCordinate());
    }
}