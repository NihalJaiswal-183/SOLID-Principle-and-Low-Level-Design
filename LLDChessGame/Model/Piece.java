package LLDChessGame.Model;

public abstract class Piece{
    private boolean isWhitePiece;
    private boolean isKilled;

    public Piece(boolean isWhitePiece){
        this.isWhitePiece = isWhitePiece;
        this.isKilled = false;
    }

    public abstract boolean canMove(Cell startCell, Cell endCell);

    public boolean isWhitePiece(){
        return this.isWhitePiece;
    }
    
    public void setKilled(){
        isKilled = true;
    }

    public boolean isKilled(){
        return isKilled;
    }
}