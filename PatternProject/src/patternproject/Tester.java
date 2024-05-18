package patternproject;

import java.util.Scanner;
  public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Creating a Factory object to create game elements
        ConcreteGameElementFactory factory = new ConcreteGameElementFactory();
        
        // Decision to start the game
        int startDecision = -1;
        
        // Loop to prompt for starting the game until a valid input is provided
        do {
            System.out.println("Do you want to start the game? Enter \"1 for yes \"or  \"0 for no\"");
            String input = sc.nextLine();
            
            // Check the user input
            if (isValidInput(input)) { // If the input is valid
                
                // Parsing the input to an integer
                startDecision = Integer.parseInt(input);
                
                // Creating the game using the Factory
                GameElement game = factory.createGame(startDecision);
                
                // Checking if the game was successfully created or not
                if (game == null) {
                    // If the game was not created
                    System.out.println("See you next time");
                } else {
                    // If the game was created successfully
                    // Starting the game
                    game.start();
                }
            } else {
                // If the user input is invalid
                System.out.println("Please enter valid entries (0 or 1)");
            }

        } while (startDecision ==- 1);// Looping until a valid input is obtained

        sc.close();
    }
  
    // Function to check the validity of the input
    private static boolean isValidInput(String input) {
        try {
            int value = Integer.parseInt(input);
            return value == 0 || value == 1;
        } catch (NumberFormatException e) {// If there's an error in parsing
            return false;
        }
        
            
    }

}