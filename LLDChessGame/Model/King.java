package LLDChessGame.Model;


class King extends Piece{

    public King(boolean isWhite){
        super(isWhite);
    }

    public boolean canMove(Cell startCell, Cell endCell){
        if(this.isWhitePiece() != endCell.getPiece().isWhitePiece()){
            return false;
        }
        return true;
    }
}