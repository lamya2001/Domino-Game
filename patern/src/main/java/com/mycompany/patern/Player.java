package com.mycompany.patern;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Domino> hand;
    private int score;
    
    //constructer 
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    //Get player name
    public String getName() {
        return name;
    }
    
    //Add to the player hand list a list of dominoes from the pack
    public void drawFromPack(Pack pack, int count) {
        for (int i = 0; i < count; i++) {
            Domino domino = pack.draw();
            if (domino != null) {
                hand.add(domino);
            }
        }
    }
    
    //Get the hand list 
    public List<Domino> getHand() {
        return hand;
    }
    
    //Get score
    public int getScore() {
        return score;
    }
    
    // Update player Score for each round
    public void updateScore() {
        // Calculate score based on the values of played dominoes
        int roundScore = hand.stream().mapToInt(domino -> domino.getSide1() + domino.getSide2()).sum();

        // Award extra points for achievements
        if (roundScore == 12) {
            score += 10; // Bonus for a sum of 12
        }

        // Add more achievements as needed
        score += roundScore;
    }
    
    //Play with the domino chosen by the player
    public void playDomino(Board board, Domino domino) {
        //Check if the specified domino is suitable for playing
        if (board.canPlace(domino)) {
            hand.remove(domino);
            board.place(domino);
        } else {
            System.out.println("Invalid move. Cannot place the domino on the board.");
        }
    }
    
    //Print the Domino list that is in player's hand
    @Override
    public String toString() {
        return name + "'s Hand: " + hand;
    }
}
