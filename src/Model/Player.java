package Model;

public class Player {
    String playername;
    //int playerAge;
    Piece playerPiece;
    Account playerAccount;
    Property playerProperty;
    int playerPosition;
    int playerType;
    int totalPlayers;

    public int setTotalPlayers(int a){
        totalPlayers = a;
    }

    public int getTotalPlayers() {
        return totalPlayers;
    }

    public void setupAccount() {
        int startingBalance = 0;
        if (totalPlayers == 2) {
            startingBalance = 20;
        } else if (totalPlayers == 3) {
            startingBalance = 18
        } else if (totalPlayers == 4) {
            startingBalance = 16;
        }

        Account account = new Account(startingBalance);
    }

    public Player(int playerType) {
        this.playerPosition = 0;
        this.playerType = playerType;
    }

    public Piece getPlayerPiece() {
        return playerPiece;
    }

    public void setupProperty() {

    }

    public void changePiecePosition(int changePosition) {

    }

    public void purchaseProperty(String field){

    }


}

