package model;

public class Piece {
    String pieceType;
    int totalMoves;
    String[] type = new String[]{"Cat", "Dog", "Boat", "Car"};

    public Piece(int playertype){
        this.totalMoves = 0;
        this.pieceType = type[playertype - 1];
    }

    public void movePiece(int addMove) {
        totalMoves = totalMoves + addMove;
    }

    public void setTotalMoves(int position){
        totalMoves = position;
    }

    public int getPieceMoves() {
        return totalMoves;
    }
    public String getPieceType(){
        return pieceType;
    }
}
