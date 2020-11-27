package Model;

public class Dice {
    int diceOutcome;

    public int rollDice() {
        int maxEye = 6;
        int minEye = 1;
        this.diceOutcome = (int) ((Math.random() * maxEye) + minEye);
        return diceOutcome;
    }
    public void setDiceOutcome(int diceOutcome) {
        this.diceOutcome = diceOutcome;
    }
}