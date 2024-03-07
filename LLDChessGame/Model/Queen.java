package LLDChessGame.Model;

public class Queen extends Piece{
    public Queen(boolean isWhitePiece){
        super(isWhitePiece);
    }

    public boolean canMove(Cell startCell, Cell endCell){
        boolean isPawnMove =endCell.getXCordinate() == startCell.getXCordinate() + 1 && 
                endCell.getYCordinate() == startCell.getYCordinate();
                
        boolean isRookMove = startCell.getXCordinate() == endCell.getXCordinate() ||
                 startCell.getXCordinate() == endCell.getYCordinate();
        
        return isPawnMove || isRookMove;
    }

}