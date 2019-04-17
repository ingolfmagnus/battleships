package no.uib.ii.gabriel;

public class BattleShips {
    public static void main(String[] args) {
        AIPlayer ai = new AIPlayer();
        HumanPlayer human = new HumanPlayer();

        GameController controller = new GameController(ai, human);
        controller.play();
    }
}
