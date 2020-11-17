package Model;

public class Player {
    String playername;
    Piece playerPiece;
    Account playerAccount;
    Property playerProperty;
    int playerPosition;
    int playerType;

    public void setupAccount(int totalPlayers) {
        int startingBalance = 0;
        if (totalPlayers == 2) {
            startingBalance = 20;
        } else if (totalPlayers == 3) {
            startingBalance = 18;
        } else if (totalPlayers == 4) {
            startingBalance = 16;
        }

        Account account = new Account(startingBalance);
    }

    public Player(int type) {
        this.playerPosition = 0;
        this.playerType = type;
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

