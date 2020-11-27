package model;


public class Player {
    String playername;
    Piece playerPiece;
    Account playerAccount;
    Property playerProperty;
    int playerPosition;
    int playerType;
    boolean canEscape;

    public Player(int type) {
        this.playerPosition = 0;
        this.playerType = type;
        this.playerPiece = new Piece(type);
        this.playerPosition = 0;
        this.playerAccount = new Account();
        this.canEscape = false;
    }

    public void movePlayerPiece(int addMove) {
        playerPiece.movePiece(addMove);
        playerPosition = playerPiece.getPieceMoves()%24;
    }

    public int getPieceMoves() {
        return playerPiece.getPieceMoves();
    }

    public void setPlayerPiece(int position){
       playerPiece.setTotalMoves (position);
    }
    public int getPosition(){
        return playerPosition;
    }

    public void setPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getPlayerType() {
        return playerType;
    }

    public void changeMoney(int money){
        playerAccount.changeTotalBalance(money);
    }
    public void setMoney(int money){
        playerAccount.setTotalBalance(money);
    }

    public void setCanEscape(){
        canEscape = true;
    }
    public void setCanNotEscape(){
        canEscape = false;
    }
    public boolean getCanEscape(){
        return canEscape;
    }
    public int getPlayerPosition() {
        return playerPosition;
    }
    public boolean isBancrupt(){
        return playerAccount.isBancrupt();
    }
    public int getMoney(){
        return playerAccount.getTotalBalance();
    }

    public void setPlayername(String name) {
        playername = name;
    }

    public String getPlayername() {
        return playername;
    }

    public Account getPlayerAccount() {
        return playerAccount;
    }

}

