package no.uib.ii.gabriel;

import java.util.Random;

public class AIPlayer extends Player {
    public AIPlayer(String aName) {
        super(aName);
    }

    @Override
    public void newGame() {
/*
        Random random = new Random();
        boolean placed = false;
        for (Ship ship : ships) {
            if (random.nextBoolean()) { // Horizontal
                do {
                    int y = random.nextInt(10);
                    int x = random.nextInt(10 - ship.getSize());
                    placed = oceanMap.placePiece(ship, new BoardLocation(x, y), Board.Orientation.HORIZONTAL);
                } while (!placed);
            }
            else {
                do {
                    int y = random.nextInt(10 - ship.getSize());
                    int x = random.nextInt(10);
                    placed = oceanMap.placePiece(ship, new BoardLocation(x, y), Board.Orientation.VERTICAL);
                } while (!placed);
            }
        }

 */
        oceanMap.placePiece(ships[0],new BoardLocation(0,0), Board.Orientation.HORIZONTAL);
        oceanMap.placePiece(ships[1],new BoardLocation(0,1), Board.Orientation.HORIZONTAL);
        oceanMap.placePiece(ships[2],new BoardLocation(0,2), Board.Orientation.HORIZONTAL);
        oceanMap.placePiece(ships[3],new BoardLocation(0,3), Board.Orientation.HORIZONTAL);
        oceanMap.placePiece(ships[4],new BoardLocation(0,4), Board.Orientation.HORIZONTAL);
    }

    @Override
    public void move(MoveInfo move) {
        checkForHit(move);
        Random r = new Random();
        move.setLocation(new BoardLocation(r.nextInt(10), r.nextInt(10)));
        return;
    }
}