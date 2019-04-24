package inf101.v19.sem2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoardTest {

    @Test
    void placePiece() {
        BoardPiece testPiece = new BoardPiece("T", 1);
        Ship testShip = new Ship("B", "Battleship", 5);
        Board testBoard = new Board();
        // Single piece in the corner
        Assertions.assertTrue (testBoard.placePiece(testPiece, new BoardLocation(9, 9), Board.Orientation.HORIZONTAL));
        // Again, but overlap
        Assertions.assertFalse(testBoard.placePiece(testPiece, new BoardLocation(9, 9), Board.Orientation.HORIZONTAL));
        // Ship at B2 down
        Assertions.assertTrue(testBoard.placePiece(testShip, new BoardLocation(1, 1), Board.Orientation.VERTICAL));
        // Ship at F2 across, overlap
        Assertions.assertFalse(testBoard.placePiece(testShip, new BoardLocation(1, 5), Board.Orientation.HORIZONTAL));
        // A8 across, over edge
        Assertions.assertFalse(testBoard.placePiece(testShip, new BoardLocation(7, 0), Board.Orientation.HORIZONTAL));
    }

}