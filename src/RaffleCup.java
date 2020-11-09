import Model.Dice;

public class RaffleCup {
    private Dice dice1 = new Dice();
    private Dice dice2 = new Dice();

    public int[] Raffle() {

        dice1.rollDice();
        dice2.rollDice();
        return new int[] {
                dice1.getFaceValue(), dice2.getFaceValue()
        };
    }
}
