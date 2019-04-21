package no.uib.ii.gabriel;

public class BattleShips {
    public static void main(String[] args) {
        AIPlayer ai = new AIPlayer("AI");
        HumanPlayer human = new HumanPlayer(Helper.readInputLine("Enter your name: "));

        GameController controller = new GameController(ai, human);
        controller.play();
    }
}
