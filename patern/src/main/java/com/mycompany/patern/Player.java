
package patternproject;

import java.util.ArrayList;
import java.util.List;


public class Player implements GameElement {
    private String name;
    private List<Domino> hand;
    private int score;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public List<Domino> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public void drawFromPack(Pack pack, int numDominos) {
        for (int i = 0; i < numDominos; i++) {
            Domino domino = pack.draw();
            if (domino != null) {
                hand.add(domino);
            }
        }
    }

    public void playDomino(Board board, Domino domino) {
        hand.remove(domino);
        board.place(domino);
    }

    public void updateScore() {
        int newScore = 0;
        for (Domino domino : hand) {
            newScore += domino.getSide1() + domino.getSide2();
        }
        score = newScore;
    }

    @Override
    public String toString() {
        return name + "'s Hand: " + hand;
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
