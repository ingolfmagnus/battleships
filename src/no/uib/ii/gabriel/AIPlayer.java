package no.uib.ii.gabriel;

public class AIPlayer extends Player {
    @Override
    public void newGame() {

        myFleet.placePieceHorizontal(ships[0], new BoardLocation(1,1));
        myFleet.placePieceHorizontal(ships[1], new BoardLocation(4,4));
        myFleet.placePieceHorizontal(ships[2], new BoardLocation(5,5));

    }
}
