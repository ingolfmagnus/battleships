package no.uib.ii.gabriel;

public class Board {

    public enum Orientation {HORIZONTAL, VERTICAL;}
    private final BoardPiece [][] array = new BoardPiece[10][10];

    public BoardPiece[][] getArray() {
        return array;
    }
    boolean placePiece(BoardPiece piece, BoardLocation location, Orientation orientation) {

        int lastX = 0;
        int lastY = 0;
        if (orientation == Orientation.HORIZONTAL) {
            lastX = location.getX() + piece.getSize() - 1;
            lastY = location.getY();
        }
        else { // VERTICAL:
            lastX = location.getX();
            lastY = location.getY() + piece.getSize() - 1;
        }

        // Check if there is free cell(s) for piece
        if (lastX < 10 && lastY < 10) {
            for (int x = location.getX(); x <= lastX; x++) {
                for (int y = location.getY(); y <= lastY; y++) {
                    // Fail if cell is not empty
                    if (array[x][y] != null)
                        return false;
                }
            }
            // Ready to place, use the same iteration
            for (int x = location.getX(); x <= lastX; x++) {
                for (int y = location.getY(); y <= lastY; y++) {
                    // Make cell point to the piece
                    array[x][y] = piece;
                }
            }
            return true;
        }
        else  // Piece would go over edge, fail
             return false;
    }

    public BoardPiece getPiece(BoardLocation location) {
        return array[location.getY()][location.getY()];
    }

    public void setPiece(BoardLocation location, BoardPiece piece) {
        array[location.getY()][location.getY()] = piece;
    }

    public void clear() {
        for (int x=0; x<10; x++)
            for (int y=0; y<10; y++)
                array[x][y] = null;
    }
}
