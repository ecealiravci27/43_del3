
import Model.Account;
import Model.Dice;
import Model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {
    @Test
    void changeTotalBalanceMinus() {
        Account account = new Account(20);
        account.changeTotalBalance(-1100);
        assertEquals(0, account.getTotalBalance());
    }

    @Test
    void changeTotalBalancePlus() {
        Account account = new Account(20);
        account.changeTotalBalance(+1100);
        assertEquals(1120, account.getTotalBalance());
    }

    @Test
    void position() {
        Player player = new Player(1);
        player.setPosition(12);
        assertEquals(12, player.getPosition());
    }

    @Test
    void rollDice() {
        Dice dice = new Dice();
        dice.rollDice();
        int eyes = dice.getFaceValue();
        dice.setDiceOutcome(2);
        assertEquals(2, dice.getFaceValue());
    }

    @Test
    void setupName() {
        Player player = new Player(1);
        player.setPlayername("Yes");
        assertEquals("Yes", player.getPlayername());
    }

    @Test
    void setupType() {
        Player player = new Player(1);
        assertEquals(1, player.getPlayerType());
    }
}
