package patternproject;

import java.util.ArrayList;
import java.util.List;

public class Player implements GameElement, Observer{
    private String name; // Name of the player
    private List<Domino> hand;// List to hold the dominoes in the player's hand
    private int score;// The player's score
    
    // Constructor to initialize the player's name, hand, and score
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }
    
    // Getter method for the player's name
    public String getName() {
        return name;
    }
    
    // Getter method for the player's hand (list of dominoes)
    public List<Domino> getHand() {
        return hand;
    }
    
    // Method to add a domino to the player's hand
    public void addToHand(Domino domino){
         hand.add(domino);
         
    }
    
    // Getter method for the player's score
    public int getScore() {
        return score;
    }
    
    // Method called when the player is notified of a change
    @Override
    public void update() {
        
        System.out.println(name + " has been notified of a change!");
        
    }
    
    // Method for the player to draw a specified number of dominoes from the pack
    public void drawFromPack(Pack pack, int numDominos) {
        for (int i = 0; i < numDominos; i++) {
            
            // Draw a domino from the pack
            Domino domino = pack.draw();
            if (domino != null) {
                hand.add(domino);// Add the drawn domino to the player's hand
            }
        }
    }
    
    // Method for the player to play a domino from their hand onto the board
    public void playDomino(Board board, Domino domino) {
        
        hand.remove(domino);// Remove the domino from the player's hand
        board.place(domino);// Place the domino on the board
    }
    
    // Method to update the player's score based on the number of dominoes in their hand
    public void updateScore() {
        
        int numberOfDominoes = hand.size();// Get the number of dominoes in the hand
        score = numberOfDominoes;// Store the number in the score variable
    }
    
    // Method to return a string representation of the player's hand
    @Override
    public String toString() {
        return name + "'s Hand: " + hand;
    }
    
    // Method to print the player's information
    @Override
    public void printInfo() {
        System.out.println("Player Name: " + name);
        System.out.println("Hand: " + hand);
        System.out.println("Score: " + score);
    }
    
    @Override
    public void start() {
        // No implementation needed for Player
    }

    @Override
    public void playRound(Player player) {
        // No implementation needed for Player
    }

    @Override
    public boolean isGameFinished() {
        // No implementation needed for Player
        return false;
    }

    @Override
    public void printFinalScores() {
        // No implementation needed for Player
    }

}
