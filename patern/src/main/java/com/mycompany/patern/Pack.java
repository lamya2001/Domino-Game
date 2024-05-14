
package patternproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public 
class Pack implements GameElement {
    @Override
    public void start() {
        System.out.println("Pack started.");
    }

    @Override
    public void playRound() {
        System.out.println("Pack played a round.");
    }

    @Override
    public boolean isGameFinished() {
        return false;
    }

    @Override
    public void printFinalScores() {
        System.out.println("Pack scores: 0");
    }
}


