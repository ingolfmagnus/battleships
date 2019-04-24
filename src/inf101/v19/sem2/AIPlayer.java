package inf101.v19.sem2;

import java.util.Random;

public class AIPlayer extends Player {
    public AIPlayer(String aName) {
        super(aName);
    }

    @Override
    public void newGame() {
        resetFleetAndBoards();

        Random random = new Random();
        boolean placed = false;
        for (Ship ship : fleet) {
            if (random.nextBoolean()) { // Horizontal
                do {
                    int y = random.nextInt(10);
                    int x = random.nextInt(10 - ship.getSize()+1);
                    placed = oceanMap.placePiece(ship, new BoardLocation(x, y), Board.Orientation.HORIZONTAL);
                } while (!placed);
            }
            else {
                do {
                    int y = random.nextInt(10 - ship.getSize()+1);
                    int x = random.nextInt(10);
                    placed = oceanMap.placePiece(ship, new BoardLocation(x, y), Board.Orientation.VERTICAL);
                } while (!placed);
            }
        }

/*

        oceanMap.placePiece(fleet[0],new BoardLocation(0,0), Board.Orientation.HORIZONTAL);
        oceanMap.placePiece(fleet[1],new BoardLocation(0,1), Board.Orientation.HORIZONTAL);
        oceanMap.placePiece(fleet[2],new BoardLocation(0,2), Board.Orientation.HORIZONTAL);
        oceanMap.placePiece(fleet[3],new BoardLocation(0,3), Board.Orientation.HORIZONTAL);
        oceanMap.placePiece(fleet[4],new BoardLocation(0,4), Board.Orientation.HORIZONTAL);

 */
    }

    @Override
    public void move(MoveInfo move) {
        //TODO: Use target map, avoid duplicate moves
        checkOpponentMove(move);
        Random r = new Random();
        move.setLocation(new BoardLocation(r.nextInt(10), r.nextInt(10)));
    }
}