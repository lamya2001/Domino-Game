
package patternproject;

import java.util.ArrayList;
import java.util.List;

public class Board implements GameElement {
    private List<Domino> playedDominos;
    private static Board board = null;

    private Board() {
        this.playedDominos = new ArrayList<>();
    }
    public static Board getBoard() {
        if (board == null) {
            board = new Board();
        }
        return board;
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
    public void start() {
        // No implementation needed for Board
    }

    public void playRound(Player player) {
        // No implementation needed for Board
    }

    public boolean isGameFinished() {
        // No implementation needed for Board
        return false;
    }

    public void printFinalScores() {
        // No implementation needed for Board
    }
}
