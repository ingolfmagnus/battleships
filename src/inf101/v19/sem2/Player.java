package inf101.v19.sem2;

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

    protected BoardLocation lastMoveLocation = null;

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

    protected void checkOpponentResponse(MoveInfo move) {
        if (lastMoveLocation != null) {
            if (move.getHitShip() != null) {
                if (this instanceof HumanPlayer) {
                    System.out.println(getName() + " HIT a " + move.getHitShip().getName() + "!");
                    if (move.getHitShip().getDurability() == 0)
                        System.out.println("It was SUNK!");
                }
                targetMap.setPiece(lastMoveLocation, new BoardPiece("*", 1));
            } else {
                if (this instanceof HumanPlayer) {
                    System.out.println(getName() + " MISSED at location: " + lastMoveLocation.getAlphaNum() + "!");
                }
                targetMap.setPiece(lastMoveLocation, new BoardPiece("O", 1));
            }
        }
    }

    protected void resetFleetAndBoards() {
        for (Ship ship : fleet) {
            ship.resetDurability();
        }
        oceanMap.clear();
        targetMap.clear();
    }

    protected boolean validMove(BoardLocation loc) {
        return (loc != null) && (targetMap.getPiece(loc) == null);
    }

    public abstract void newGame();

    public abstract void move(MoveInfo move);
}
