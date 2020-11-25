package model;

public class Card extends Field {
    public Card(boolean goToStart,boolean goToColor, boolean goToStrandPromade, boolean canEscape, boolean goUpToFive, boolean birthday, int changeMoney, int movePiece, String color){
        super();
        this.goToStart = goToStart;
        this.goToColor = goToColor;
        this.goToStrandPromade = goToStrandPromade;
        this.goUpToFive = goUpToFive;
        this.canEscape = canEscape;
        this.changeMoney = changeMoney;
        this.movePiece = movePiece;
   }
}
