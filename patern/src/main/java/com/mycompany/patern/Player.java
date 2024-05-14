
package patternproject;

import java.util.ArrayList;
import java.util.List;


public class Player implements GameElement {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void start() {
        System.out.println("Player " + name + " started.");
    }

    @Override
    public void playRound() {
        System.out.println("Player " + name + " played a round.");
    }

    @Override
    public boolean isGameFinished() {
        return false;
    }

    @Override
    public void printFinalScores() {
        System.out.println("Player " + name + " score: 100");
    }
}
