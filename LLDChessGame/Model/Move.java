package LLDChessGame.Model;

public class Move {
    private Player player;
    private Cell start;
    private Cell end;
    private Piece pieceMoved;
    private Piece pieceKilled;
 
    public Move(Player player, Cell start, Cell end){
        this.player = player;
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
    }
}