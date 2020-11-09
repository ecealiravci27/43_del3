package Model;

public class Dice {
    int faceValue;


    public int getFaceValue() {
        return faceValue;
    }

    public void rollDice() {
        int maxEye = 6;
        int minEye = 1;
        this.faceValue = (int) ((Math.random() * maxEye) + minEye);
    }

}