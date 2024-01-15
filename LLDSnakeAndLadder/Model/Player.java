package LLDSnakeAndLadder.Model;

public class Player{
    String name;
    String id;
    int playerCurrentPos;

    public Player(String name, String id){
        this.name = name;
        this.id = id;
        this.playerCurrentPos = 0;
    }
}