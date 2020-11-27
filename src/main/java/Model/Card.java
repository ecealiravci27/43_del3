package Model;

public class Card extends Field {
    public Card(boolean goToStart,boolean goToColor, boolean goToStrandPromade, boolean canEscape, boolean goUpToFive, boolean birthday, int changeMoney, int movePiece, String color){
        super();
        this.goToStart = goToStart;
        this.goToColor = goToColor;
        this.goToStrandPromade = goToStrandPromade;
        this.canEscape = canEscape;
        this.goUpToFive = goUpToFive;
        this.changeMoney = changeMoney;
        this.movePiece = movePiece;
        this.color = color;
   }
}
