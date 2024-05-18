package patternproject;

import java.util.ArrayList;
import java.util.List;

public class Board implements GameElement ,Subject{
    private List<Domino> playedDominos;// List to store the dominoes that have been played on the board
    private static Board board = null;// Static variable for singleton instance of Board
    private List<Observer> observers;// List to store the observers "players"
     
    // Private constructor to prevent instantiation from outside 
    private Board() {
        this.playedDominos = new ArrayList<>();
        this.observers = new ArrayList<>();
    }
    
    // Method to get the singleton instance of the Board
    public static Board getBoard() {
        if (board == null) {
            board = new Board();// Instantiate the Board if it hasn't been already
        }
        return board;
    }
    
    // Method to attach an observer to the list
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }
    
    // Method to detach an observer from the list
    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }
    
    // Method to notify all observers of changes
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();// Call the update method on each observer "player"
        }
    }
    
    // Method to check if a domino can be placed on the board
    public boolean canPlace(Domino domino) {
        
        if (playedDominos.isEmpty()) {// If the board is empty, any domino can be placed
            return true;
        }
        int head = playedDominos.get(0).getSide1();
        int tail = playedDominos.get(playedDominos.size() - 1).getSide2();

        // Check if the domino can be placed at either end of the played dominoes
        return domino.getSide1() == head || domino.getSide2() == head ||
                domino.getSide1() == tail || domino.getSide2() == tail;
    }
    
    // Method to remove a domino from the board
    public void remove(Domino domino) {
        if (playedDominos.isEmpty()) {
            System.out.println("The board is empty.");
            return;
        }

        // Check and remove the domino from the beginning of the board
        if (playedDominos.get(0).equals(domino) || playedDominos.get(0).equals(new Domino(domino.getSide2(), domino.getSide1()))) {
            playedDominos.remove(0);
            notifyObservers();// Notify observers of the change
            return;
        }

        // Check and remove the domino from the end of the board
        if (playedDominos.get(playedDominos.size() - 1).equals(domino) || playedDominos.get(playedDominos.size() - 1).equals(new Domino(domino.getSide2(), domino.getSide1()))) {
            playedDominos.remove(playedDominos.size() - 1);
            notifyObservers();// Notify observers of the change
            return;
        }

        System.out.println("The domino " + domino + " is not on the board.");
    }

    // Method to place a domino on the board
    public void place(Domino domino) {
        if (playedDominos.isEmpty()) {
            playedDominos.add(domino);// Add the domino to the board if it's empty
            notifyObservers();// Notify observers of the change
            return;
        }

        int head = playedDominos.get(0).getSide1();
        int tail = playedDominos.get(playedDominos.size() - 1).getSide2();

        // Check where the domino can be placed and place it accordingly
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
        notifyObservers(); // Notify observers of the change
    }

    // Method to return a string representation of the board
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
    
    // Method to print information about the board
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
