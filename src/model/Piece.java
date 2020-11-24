package model;

public class Piece {
    String pieceType;
    int totalMoves;
    String[] type = new String[]{"Cat", "Dog", "Boat", "Car"};


    private void movePiece(int addMove) {
        this.totalMoves = totalMoves + addMove;
    }
    public void setTotalMoves(int position){
        this.totalMoves = position;
    }

    void setPieceType(int a) {
        this.pieceType = type[a];
    }

    public int getPieceMoves() {
        return totalMoves;
    }
}
