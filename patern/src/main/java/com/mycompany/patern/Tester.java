
package patternproject;

import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        // Create game elements
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Board board = new Board();
        Pack pack = new Pack();

        Scanner sc = new Scanner(System.in);
        GameElementFactory factory = new ConcreteGameElementFactory();
        int startDecision = -1;

        do {
            System.out.println("Do you want to start the game? Enter 1 for yes or 0 for no");
            String input = sc.nextLine();

            if (isValidInput(input)) {
                startDecision = Integer.parseInt(input);
                
                Game game = factory.createGame(startDecision);

                if (game == null) {
                    System.out.println("See you next time");
                } else {
                    game.start();
                }
            } else {
                System.out.println("Please enter valid entries (0 or 1)");
            }

        } while (startDecision ==- 1);

        sc.close();


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
    private static boolean isValidInput(String input) {
        try {
            int value = Integer.parseInt(input);
            return value == 0 || value == 1;
        } catch (NumberFormatException e) {
            return false;
        }
             
    }
}
