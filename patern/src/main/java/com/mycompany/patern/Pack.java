
package patternproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Pack implements GameElement {
    private List<Domino> dominos;
    private static Pack pack = null;

    Pack() {
        dominos = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                dominos.add(new Domino(i, j));
            }
        }
        shuffle();
    }

    public static Pack getPack() {
        if (pack == null) {
            pack = new Pack();
        }
        return pack;
    }

    public boolean isEmpty() {
        return dominos.isEmpty();
    }

    public void shuffle() {
        Collections.shuffle(dominos);
    }

    public Domino draw() {
        if (!dominos.isEmpty()) {
            return dominos.remove(0);
        }
        return null;
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
