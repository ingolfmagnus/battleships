package no.uib.ii.gabriel;

public class HumanPlayer extends Player {

    private BoardLocation lastMoveLocation = null;

    public HumanPlayer(String aName) {
        super(aName);
    }

    @Override
    public void newGame() {
        resetFleetAndBoards();

        System.out.println("Placement of fleet");

        for (Ship ship : fleet) {
            boolean inputOK = false;
            do {
                //TODO: Stricter input checking
                String alphaNum = Helper.readInputLine("Where do you place the " + ship.getName() +
                        " of size " + ship.getSize() + " [A1-J10] ? ");
                String oText = Helper.readInputLine("To the [R]ight or [D]own?");
                Board.Orientation orientation =
                        oText.equalsIgnoreCase("R") ? Board.Orientation.HORIZONTAL : Board.Orientation.VERTICAL;
                try{
                    inputOK = oceanMap.placePiece(ship, new BoardLocation(alphaNum), orientation);
                    if (inputOK) Helper.printBoard(oceanMap);
                }
                catch (Exception E) {
                    inputOK = false;
                }
                if (!inputOK)
                    System.out.println("Error or overlap. Please try again:");
            } while (!inputOK);
        }

        /*
        oceanMap.placePiece(fleet[0], new BoardLocation(0, 0), Board.Orientation.HORIZONTAL);
        oceanMap.placePiece(fleet[1], new BoardLocation(0, 1), Board.Orientation.HORIZONTAL);
        oceanMap.placePiece(fleet[2], new BoardLocation(0, 2), Board.Orientation.HORIZONTAL);
        oceanMap.placePiece(fleet[3], new BoardLocation(0, 3), Board.Orientation.HORIZONTAL);
        oceanMap.placePiece(fleet[4], new BoardLocation(0, 4), Board.Orientation.HORIZONTAL);

         */

    }

    @Override
    public void move(MoveInfo move) {
        checkOpponentResponse(move);
        checkOpponentMove(move);

        if (move.getHitShip() != null) {
            System.out.println("Your ship " + move.getHitShip().getName() + " was hit.");
            if (move.getHitShip().getDurability() == 0)
                System.out.println("SUNK!");
        }

        Helper.printBoard(targetMap);
        Helper.printBoard(oceanMap);

        makeNewMove(move);
    }

    private void makeNewMove(MoveInfo move) {
        BoardLocation loc = null;
        boolean inputOK;
        do {
            inputOK = true;
            try {
                loc = new BoardLocation(Helper.readInputLine("Bomb target [A1-J10]: "));
            } catch (IllegalArgumentException e) {
                inputOK = false;
                System.out.println("Invalid input. Type a letter A-J followed by a number 1-10, e.g. B5.");
            }
        } while (!inputOK);
        move.setLocation(loc);
        lastMoveLocation = loc;
    }

    private void checkOpponentResponse(MoveInfo move) {
        //TODO: Check for duplicate moves when doing move
        if (lastMoveLocation != null) {
            if (move.getHitShip() != null) {
                System.out.println("You HIT a " + move.getHitShip().getName());
                if (move.getHitShip().getDurability() == 0)
                    System.out.println("SUNK!");
                targetMap.setPiece(lastMoveLocation, new BoardPiece("*", 1));
            } else if (targetMap.getPiece(lastMoveLocation) == null) {
                targetMap.setPiece(lastMoveLocation, new BoardPiece("O", 1));
            }
        }
    }


}
