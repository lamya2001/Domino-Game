
package patternproject;

import java.util.ArrayList;
import java.util.List;

ublic class Tester {
    public static void main(String[] args) {
        // Create game elements
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Board board = new Board();
        Pack pack = new Pack();

        // Construct the composite structure
        board.addElement(player1);
        board.addElement(player2);
        board.addElement(pack);

        // Start the game
        board.start();

        // Play a round
        board.playRound();

        // Check if the game is finished
        if (board.isGameFinished()) {
            System.out.println("The game is finished.");
        } else {
            System.out.println("The game is not finished.");
        }

        // Print final scores
        board.printFinalScores();
    }
}
