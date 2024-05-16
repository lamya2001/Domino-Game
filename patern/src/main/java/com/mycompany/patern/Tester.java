package patternproject;

import java.util.Scanner;
  public class Tester {
    public static void main(String[] args) {
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
