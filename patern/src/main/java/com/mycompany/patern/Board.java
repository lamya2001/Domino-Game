package patternproject;

import java.util.ArrayList;
import java.util.List;

public class Board implements GameElement, Subject{
    private List<Domino> playedDominos;
    private static Board board = null;
    private List<Observer> observers;

    private Board() {
        this.playedDominos = new ArrayList<>();
        this.observers = new ArrayList<>();
    }
    public static Board getBoard() {
        if (board == null) {
            board = new Board();
        }
        return board;
    }
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }
    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    public boolean canPlace(Domino domino) {
    if (playedDominos.isEmpty()) {
        return true;
    }
    int head = playedDominos.get(0).getSide1();
    int tail = playedDominos.get(playedDominos.size() - 1).getSide2();
    return domino.getSide1() == head || domino.getSide2() == head ||
            domino.getSide1() == tail || domino.getSide2() == tail;
}

    public void place(Domino domino) {
    if (playedDominos.isEmpty()) {
        playedDominos.add(domino);
        notifyObservers();
        return;
    }

    int head = playedDominos.get(0).getSide1();
    int tail = playedDominos.get(playedDominos.size() - 1).getSide2();

    if (domino.getSide1() == head) {
        playedDominos.add(0, new Domino(domino.getSide2(), domino.getSide1()));
    } else if (domino.getSide2() == head) {
        playedDominos.add(0, domino);
    } else if (domino.getSide1() == tail) {
        playedDominos.add(domino);
    } else if (domino.getSide2() == tail) {
        playedDominos.add(new Domino(domino.getSide2(), domino.getSide1()));
    } else {
        System.out.println("Invalid move. Cannot place the selected domino on the board.");
    }
}




    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Board: [");
        for (Domino domino : playedDominos) {
            stringBuilder.append("[")
                         .append(domino.getSide1())
                         .append("|")
                         .append(domino.getSide2())
                         .append("], ");
        }
        if (stringBuilder.length() > 8) { 
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()); 
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
    
    @Override
    public void printInfo() {
        System.out.println("Board: " + this);
    }  
    @Override
    public void start() {
        // No implementation needed for Board
    }

    @Override
    public void playRound(Player player) {
        // No implementation needed for Board
    }

    @Override
    public boolean isGameFinished() {
        // No implementation needed for Board
        return false;
    }

    @Override
    public void printFinalScores() {
        // No implementation needed for Board
    }
}
