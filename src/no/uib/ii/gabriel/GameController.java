package no.uib.ii.gabriel;

public class GameController {
    private final Player playerOne;
    private final Player playerTwo;

    public GameController(Player one, Player two) {
        playerOne = one;
        playerTwo = two;
    }

    public void play() {
        playerOne.newGame();
        playerTwo.newGame();


    }
}
