package patternproject;

public interface GameElement {
    void start();
    void playRound(Player player);
    boolean isGameFinished();
    void printFinalScores();
    void printInfo(); // New method for printing information about the game element
}
