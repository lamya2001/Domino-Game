package patternproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pack implements GameElement {
    private List<Domino> dominos;// List to store the dominos in the pack
    private static Pack pack = null;// Static variable for the singleton instance of Pack
    
    // Private constructor to prevent instantiation from outside
   private Pack() {
        dominos = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                dominos.add(new Domino(i, j));// Add all combinations of dominos (0-0 to 6-6) to the pack
            }
        }
        shuffle();// Shuffle the dominos after creation
    }
   
    // Method to get the singleton instance of the Pack
    public static Pack getPack() {
        if (pack == null) {
            pack = new Pack();// Instantiate the Pack if it hasn't been already
        }
        return pack;
    }
    
    // Method to check if the pack is empty
    public boolean isEmpty() {
        return dominos.isEmpty();
    }
    
    // Method to shuffle the dominos in the pack
    public void shuffle() {
        Collections.shuffle(dominos);
    }

    // Method to draw a domino from the pack
    public Domino draw() {
        if (!dominos.isEmpty()) {
            return dominos.remove(0);// Remove and return the first domino in the list
        }
        return null;// Return null if the pack is empty
    }
    
    // Method to print information about the pack
       @Override
    public void printInfo() {
        System.out.println("Pack contains " + dominos.size() + " dominos.");
    }

    @Override
    public void start() {
        // No implementation needed for Pack
    }

    @Override
    public void playRound(Player player) {
        // No implementation needed for Pack
    }

    @Override
    public boolean isGameFinished() {
        // No implementation needed for Pack
        return false;
    }
    @Override
    public void printFinalScores() {
        // No implementation needed for Pack
    }
}
