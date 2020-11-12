package Model;

public class Player {
    String playername;
    //int playerAge;
    Piece playerPiece;
    Account playerAccount;
    Property playerProperty;
    int playerPosition;

    public void setupAccount() {

    }

    public Player(int playerType, String playerName) {
        this.playerPosition = 0;
    }

    public Piece getPlayerPiece() {
        return playerPiece;
    }

    public void setupProperty() {

    }

    public void changetotalBalance(int changeMoney) {

    }

    public void changePiecePosition(int changePosition) {

    }

    public void purchaseProperty(String field){

    }


}

