package Model;

import java.util.ArrayList;

public class Piece {
    int pieceType;
    int totalMoves;
    int[] type = new int[]{1, 2, 3, 4};


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
