package LLDChessGame.Model;

public class Rook extends Piece{
    public Rook(boolean isWhitePiece){
        super(isWhitePiece);
    }
    
    public boolean canMove(Cell startCell, Cell endCell){
        return startCell.getXCordinate() == endCell.getXCordinate() ||
         startCell.getXCordinate() == endCell.getYCordinate();
    }
}