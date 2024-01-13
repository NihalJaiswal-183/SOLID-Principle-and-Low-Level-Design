package LLDTicTacToe.Model;

public class PlayerFactory{
    public Player getPlayerInstance(String playerName, String playingEntity){
        if(playingEntity.equals("X")){
            return new Player(playerName, PlayingEntity.X);
        }
        else if(playingEntity.equals("O")){
            return new Player(playerName, PlayingEntity.O);
        }
        return null;
    }
}
