package inf101.v19.sem2;

public class HumanPlayer extends Player {

    public HumanPlayer(String aName) {
        super(aName);
    }

    @Override
    public void newGame() {
        resetFleetAndBoards();

        System.out.println("Placement of fleet");
        /*
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

         */

        oceanMap.placePiece(fleet[0], new BoardLocation(0, 0), Board.Orientation.HORIZONTAL);
        oceanMap.placePiece(fleet[1], new BoardLocation(0, 1), Board.Orientation.HORIZONTAL);
        oceanMap.placePiece(fleet[2], new BoardLocation(0, 2), Board.Orientation.HORIZONTAL);
        oceanMap.placePiece(fleet[3], new BoardLocation(0, 3), Board.Orientation.HORIZONTAL);
        oceanMap.placePiece(fleet[4], new BoardLocation(0, 4), Board.Orientation.HORIZONTAL);



    }

    @Override
    public void move(MoveInfo move) {
        checkOpponentResponse(move);
        checkOpponentMove(move);

        System.out.println("\n=========== " + getName() + "'s turn =========== ");

        if (move.getHitShip() != null) {
            System.out.println(move.getPlayerName() + " HIT your ship " + move.getHitShip().getName());
            if (move.getHitShip().getDurability() == 0)
                System.out.println("SUNK!");
        } else if (move.getLocation() != null) { // Null if first move in gameg
            System.out.println(move.getPlayerName() + " MISSED at location: " + move.getLocation().getAlphaNum() + "!");
        }

        Helper.printBoard(targetMap);
        Helper.printBoard(oceanMap);

        makeNewMove(move);
        move.setPlayerName(getName());
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
            if (!validMove(loc)){
                inputOK = false;
                System.out.println("Target already bombed, bomb a new target!");
            }
        } while (!inputOK);
        move.setLocation(loc);
        lastMoveLocation = loc;
    }


}
