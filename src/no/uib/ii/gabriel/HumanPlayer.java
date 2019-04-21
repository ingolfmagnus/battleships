package no.uib.ii.gabriel;

public class HumanPlayer extends Player {

    private BoardLocation lastMoveLocation = null;
    public HumanPlayer(String aName) {
        super(aName);
    }


    @Override
    public void newGame() {

        System.out.println("Placement of ships");
        for (Ship ship : ships) {
            boolean inputOK = false;
            do {
                String alphaNum = Helper.readInputLine("Where do you place the " + ship.getName() +
                        " of size " + ship.getSize() + " [A-J1-10] ? ");
                String oText = Helper.readInputLine("[A]cross or [D]own?");
                Board.Orientation orientation =
                        oText.equalsIgnoreCase("A") ? Board.Orientation.HORIZONTAL : Board.Orientation.VERTICAL;
                try{
                    inputOK = oceanMap.placePiece(ship, new BoardLocation(alphaNum), orientation);
                    if (inputOK) printBoard(oceanMap);
                }
                catch (Exception e) {
                    inputOK = false;
                }
                if (!inputOK)
                    System.out.println("Error or overlap. Please try again:");
            } while (! inputOK);
        }

    }

    @Override
    public void move(MoveInfo move) {
        if (move.getHitShip() != null) {
            System.out.println("HIT of ship " + move.getHitShip().getName());
            if (move.getHitShip().getDurability() == 0)
                System.out.println("SUNK!");
            if (lastMoveLocation != null)
                targetMap.setPiece(lastMoveLocation, new BoardPiece("*",1));
        }
        else if (lastMoveLocation != null)
            targetMap.setPiece(lastMoveLocation, new BoardPiece("O",1));


        checkForHit(move);

        printBoard(targetMap);
        printBoard(oceanMap);

        BoardLocation loc = null;
        boolean inputOK = true;
        do {
            try {
                loc = new BoardLocation(Helper.readInputLine("Bomb target [A1-J10]: "));
            }
            catch (IllegalArgumentException e) {
                inputOK = false;
            }
        } while (! inputOK);
        move.setLocation(loc);
        lastMoveLocation = loc;
        return;
    }

    private void printBoard(Board theMap) {
        BoardPiece[][] pieceArray = theMap.getArray();
        System.out.println("   1 2 3 4 5 6 7 8 9 10");
        for (int y = 0; y < 10; y++) {
            System.out.print((char)('A'+y));System.out.print('|');
            for (int x = 0; x < 10; x++) {
                if (pieceArray[x][y] != null)
                    System.out.print(" " + pieceArray[x][y].getSymbol());
                else
                    System.out.print("..");
            }
            System.out.println();
        }
    }
}
