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
        this.playerAccount = new Account();
        this.canEscape = false;
    }


    public void movePlayerPiece(int addMove) {
        playerPiece.movePiece(addMove);
    }

    public int getPieceMoves() {
        return playerPiece.getPieceMoves();
    }

    public void setPlayerPiece(int position){
       playerPiece.setTotalMoves (position);
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




    public void changePiecePosition(int changePosition) {
    }

}

