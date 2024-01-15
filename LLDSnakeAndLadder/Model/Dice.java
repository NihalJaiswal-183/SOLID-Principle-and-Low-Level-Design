package LLDSnakeAndLadder.Model;

public class Dice{
    int minValue;
    int maxValue;
    int noOfDice;

    public Dice(int noOfDice){
        this.noOfDice = noOfDice;
        this.minValue = 1;
        this.maxValue = 6;
    }

    public int rollDice(){
        int diceSum = 0;
        for(int dice=1; dice<=noOfDice; dice++){
           diceSum += (int)( Math.random() * 6 ) + 1;
        }
        return diceSum;
    }
}