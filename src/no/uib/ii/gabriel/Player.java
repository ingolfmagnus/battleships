package no.uib.ii.gabriel;

/**
 *
 */
public abstract class Player {

    protected String name;
    protected Board oceanMap = new Board();
    protected Board targetMap = new Board();
    protected Ship[] fleet = {
            new Ship("C", "Carrier", 5),
            new Ship("B", "Battleship", 4),
            new Ship("D", "Destroyer", 3),
            new Ship("S", "Submarine", 3),
            new Ship("P", "Patrol", 2)
    };

    /**
     *
     * @param theName The player's displayed name
     */
    public Player(String theName) {
        name = theName;
    }

    public String getName() {
        return name;
    }

    public int getFleetDurability() {
        int sum = 0;
        for (Ship ship : fleet)
            sum += ship.getDurability();
        return sum;
    }

    protected void checkOpponentMove(MoveInfo move) {
        // See if there is a move and if so, if we are hit
        if (move.getLocation() != null) {
            BoardPiece piece = oceanMap.getPiece(move.getLocation());
            boolean isAHit = piece instanceof Ship;
            if (isAHit) {
                ((Ship) piece).hit();
                oceanMap.setPiece(move.getLocation(), new BoardPiece("*", 1));
            }
            move.setHitShip(piece);

        }
    }

    protected void resetFleetAndBoards() {
        for (Ship ship : fleet) {
            ship.resetDurability();
        }
        oceanMap.clear();
        targetMap.clear();
    }

    public abstract void newGame();

    public abstract void move(MoveInfo move);
}
