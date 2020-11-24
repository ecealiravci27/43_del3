package model;

public class Dice {
    int diceOutcome;


    public int getFaceValue() {
        return diceOutcome;
    }

    public void rollDice() {
        int maxEye = 6;
        int minEye = 1;
        this.diceOutcome = (int) ((Math.random() * maxEye) + minEye);
    }

    public void setDiceOutcome(int diceOutcome) {
        this.diceOutcome = diceOutcome;
    }
}