package no.uib.ii.gabriel;

public class BattleShips {
    public static void main(String[] args) {
        // HumanPlayer human = new HumanPlayer(Helper.readInputLine("Enter your name: "));
        AIPlayer ai = new AIPlayer("PC");
        AIPlayer ai2 = new AIPlayer("Mac");

        GameController controller = new GameController(ai, ai2);
        controller.play();
    }
}
