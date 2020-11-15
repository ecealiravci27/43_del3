package Model;

import java.util.ArrayList;

public class Piece {
    String pieceType;
    int totalMoves;
    String[] type = new String[]{"Cat", "Dog", "Boat", "Car"};


    private void movePiece(int addMove) {
        this.totalMoves = addMove;
    }

    private void setPieceType(int a) {
        this.pieceType = type[a];
    }

    private int getPieceMoves() {
        return totalMoves;
    }
}
