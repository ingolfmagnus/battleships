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

        MoveInfo moveInfo = new MoveInfo();
        do {
            playerOne.move(moveInfo);
            playerTwo.move(moveInfo);
        } while (playerOne.getFleetDurability()>0 && playerTwo.getFleetDurability() > 0);
        Player victor = playerOne.getFleetDurability() == 0 ? playerTwo : playerOne;
        System.out.println(victor.getName() + " wins!");
    }
}
