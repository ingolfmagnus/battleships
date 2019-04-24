package inf101.v19.sem2;

import java.util.Random;

public class BattleShips {
    public static void main(String[] args) {
        HumanPlayer human = new HumanPlayer(Helper.readInputLine("Enter your name: "));
        AIPlayer ai = new AIPlayer("AI");
        //AIPlayer ai2 = new AIPlayer("Mac");

        GameController controller;
        if (new Random().nextBoolean()) { // Decide randomly who goes first
            System.out.println(ai.getName() + " goes first.");
            controller = new GameController(ai, human);
        } else {
            System.out.println(human.getName() + " goes first.");
            controller = new GameController(human, ai);
        }
        controller.play();
    }
}
