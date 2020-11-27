
import model.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {
    @Test
    public void changeTotalBalanceMinus() {
        Account account = new Account();
        account.changeTotalBalance(-1100);
        assertEquals(0, account.getTotalBalance());
    }

    @Test
    public void changeTotalBalancePlus() {
        Account account = new Account();
        account.changeTotalBalance(+1100);
        assertEquals(1101, account.getTotalBalance());
    }

    @Test
    public void position() {
        Player player = new Player(1);
        player.setPosition(12);
        assertEquals(12, player.getPosition());
    }

    @Test
    public void setupName() {
        Player player = new Player(1);
        player.setPlayername("Yes");
        assertEquals("Yes", player.getPlayername());
    }

    @Test
    public void setupType() {
        Player player = new Player(1);
        assertEquals(1, player.getPlayerType());
    }

    @Test
    public void buyProperty() {
        Player player = new Player(3);
        Property property = new Property();
        Board board = new Board();
        player.setPosition(23);
        int position = (player.getPlayerPosition());
        int[] rulesI = board.getField(position).getIntRules();
        int change = rulesI[2];
        player.getPlayerAccount().setTotalBalance(10);
        player.changeMoney((-change));
        property.buy(position, player.getPlayerType());
        assertEquals(5, player.getPlayerAccount().getTotalBalance());
        int owner = property.getOwner(position);
        assertEquals(3, owner);
    }

    @Test
    public void payRent() {
        Player player = new Player(3);
        Property property = new Property();
        player.setPosition(20);
        int position = (player.getPlayerPosition());
        property.buy(position, player.getPlayerType());
        int owner = property.getOwner(position);
        assertEquals(3, owner);

        Player prent = new Player(2);

        Board board = new Board();
        int[] rulesI = board.getField(position).getIntRules();
        int change = rulesI[2];
        prent.setMoney(7);

        prent.changeMoney((-change));
        player.changeMoney(change);

        assertEquals(3, prent.getMoney());
        assertEquals(5, player.getMoney());
    }
}
