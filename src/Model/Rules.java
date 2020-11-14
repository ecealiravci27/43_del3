package Model;
//should probably rename to just "rule" as classes are usually in singular
public class Rules  {
    int changeMoney;
    int addMove;
    boolean buy;
    boolean drawCard; //remember that getCard() is a method in cardPile. this should be called drawCard via the class diagram

    public Rules(int change, int move, boolean procure, boolean draw){
        this.changeMoney = change;
        this.addMove = move;
        this.buy = procure ; //could rename this to "interact, as you only buy a property when you can, otherwise pay for rent
        this.drawCard = draw;
    }
}
