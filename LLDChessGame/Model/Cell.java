package LLDChessGame.Model;


public class Cell{
    private int x;
    private int y;
    private Piece piece;

    public Cell(int x, int y, Piece piece){
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public boolean isCellEmpty(){
        return this.piece == null;
    }

    public Piece getPiece(){
        return this.piece;
    }

    public int getXCordinate(){
        return this.x;
    }

    public int getYCordinate(){
        return this.y;
    }

    public void makeCellEmpty(){
        this.piece = null;
    }

    public void setCell(Piece piece){
        this.piece = piece;
    }
}