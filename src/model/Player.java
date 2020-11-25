package model;


public class Player {
    String playername;
    Piece playerPiece;
    Account playerAccount;
    Property playerProperty;
    int playerPosition;
    int playerType;

    public Player(int type) {
        this.playerPosition = 0;
        this.playerType = type;
        this.playerPiece = new Piece();
    }

    public void setupAccount(int totalPlayers) {
        int startingBalance = 0;
        if (totalPlayers == 2) {
            startingBalance = 20;
        } else if (totalPlayers == 3) {
            startingBalance = 18;
        } else if (totalPlayers == 4) {
            startingBalance = 16;
        }
        Account playerAccount = new Account(startingBalance);
    }

    public void setPlayerPiece(int position){
       playerPiece.setTotalMoves (position);
    }

    public int getPlayerType() {
        return playerType;
    }

    public void setupProperty() {

    }

    public void changePiecePosition(int changePosition) {

    }

    public void purchaseProperty(String field){

    }


}

