package LLDChessGame.Model;

public class Pawn extends Piece{
    public Pawn(boolean isWhitePiece){
        super(isWhitePiece);
    }
    
    public boolean canMove(Cell startCell, Cell endCell){
        if(this.isWhitePiece() != endCell.getPiece().isWhitePiece()){
            return false;
        }

        return endCell.getXCordinate() == startCell.getXCordinate() + 1 && endCell.getYCordinate() == startCell.getYCordinate();
    }
}