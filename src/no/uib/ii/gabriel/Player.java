package no.uib.ii.gabriel;

public abstract class Player {

    protected Board myFleet;
    protected Board myBombings;

    protected Ship[] ships = {
        new Ship("C", "Carrier", 5),
        new Ship("B", "Battleship", 4),
        new Ship("D", "Destroyer", 3),
        new Ship("S", "Submarine", 3),
        new Ship("P", "Patrol", 2)
    };

    public int getTotalLives() {
        int sum = 0;
        for (Ship ship : ships)
            sum += ship.getLives();
        return sum;
    }

    public boolean bomb(BoardLocation location) {
        BoardPiece piece = myFleet.getArray()[location.getX()][location.getY()];
        if (piece instanceof Ship) {
            Ship ship = (Ship) piece;
            ship.hit();
            myFleet.getArray()[location.getX()][location.getY()] = null;
            return true;
        }
        return false;
    }

    public abstract void newGame();
}
