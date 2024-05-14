
package patternproject;

import java.util.ArrayList;
import java.util.List;
public class Board implements GameElement {
    private List<GameElement> gameElements;

    public Board() {
        gameElements = new ArrayList<>();
    }

    public void addElement(GameElement element) {
        gameElements.add(element);
    }

    public void removeElement(GameElement element) {
        gameElements.remove(element);
    }

    @Override
    public void start() {
        System.out.println("Board started.");
        for (GameElement element : gameElements) {
            element.start();
        }
    }

    @Override
    public void playRound() {
        System.out.println("Board played a round.");
        for (GameElement element : gameElements) {
            element.playRound();
        }
    }

    @Override
    public boolean isGameFinished() {
        for (GameElement element : gameElements) {
            if (!element.isGameFinished()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void printFinalScores() {
        System.out.println("Board final scores:");
        for (GameElement element : gameElements) {
            element.printFinalScores();
        }
    }
}







