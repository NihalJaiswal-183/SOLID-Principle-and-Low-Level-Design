package LLDTicTacToe.Model;

public class Player{
    public String name;
    public PlayingEntity playingEntity;

    public Player(String name, PlayingEntity playingEntity){
        this.name = name;
        this.playingEntity = playingEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayingEntity getPlayingPiece() {
        return playingEntity;
    }

    public void setPlayingPiece(PlayingEntity playingEntity) {
        this.playingEntity = playingEntity;
    }

}