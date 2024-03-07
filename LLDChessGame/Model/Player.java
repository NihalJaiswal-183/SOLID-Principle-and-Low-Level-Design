package LLDChessGame.Model;

public class Player {
    private String name;
    private boolean whiteSide = false;
    public Player(String name, boolean whiteSide){
        this.name = name;
        this.whiteSide = whiteSide;
    }
    public boolean isWhiteSide() {
        return this.whiteSide == true;
    }

    public String getPlayerName(){
        return this.name;
    }
}
