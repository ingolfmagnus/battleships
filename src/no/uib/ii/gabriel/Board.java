package no.uib.ii.gabriel;

public class Board {
    private final BoardPiece [][] array = new BoardPiece[10][10];


    public BoardPiece[][] getArray() {
        return array;
    }

    boolean placePieceHorizontal(BoardPiece piece, BoardLocation location) {
        int lastX = location.getX() + piece.getSize() - 1;
        if (lastX <= 10) {
            for (int x = location.getX(); x <= lastX; x++) {
                if (array[x][location.getY()] == null)
                    array[x][location.getY()] = piece;
                else
                    return false;
            }
            return true;
        }
        else
            return false;
    }
    boolean placePieceVertical(BoardPiece piece, BoardLocation location) {
        int lastY = location.getY() + piece.getSize() - 1;
        if (lastY <= 10) {
            for (int y = location.getY(); y <= lastY; y++) {
                if (array[location.getX()][y] == null)
                    array[location.getX()][y] = piece;
                else
                    return false;
            }
            return true;
        }
        else
            return false;
    }
}
