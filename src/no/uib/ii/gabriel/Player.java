package no.uib.ii.gabriel;

public abstract class Player {

    protected String name;
    protected Board oceanMap = new Board();
    protected Board targetMap = new Board();
    protected Ship[] ships = {
        new Ship("C", "Carrier", 5),
        new Ship("B", "Battleship", 4),
        new Ship("D", "Destroyer", 3),
        new Ship("S", "Submarine", 3),
        new Ship("P", "Patrol", 2)
    };

    public Player(String theName) {
        name = theName;
    }

    public String getName() {
        return name;
    }

    public int getFleetDurability() {
        int sum = 0;
        for (Ship ship : ships)
            sum += ship.getDurability();
        return sum;
    }

    protected void checkForHit(MoveInfo move) {
        // See if there is a move and if so, if we are hit
        if (move.getLocation() != null) {
            BoardPiece piece = oceanMap.getPiece(move.getLocation());
            boolean isAHit = piece instanceof Ship;
            if (isAHit) {
                ((Ship) piece).hit();
                oceanMap.setPiece(move.getLocation(), new BoardPiece(piece.getSymbol().toLowerCase(), 1));
            }
            move.setHitShip(piece);

        }
    }

    public abstract void newGame();
    public abstract void move(MoveInfo move);
}
