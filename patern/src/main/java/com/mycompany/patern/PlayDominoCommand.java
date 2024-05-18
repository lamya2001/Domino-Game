package patternproject;

// Concrete Command
public class PlayDominoCommand implements Command {
    private Player player;// Field to store the player who will play the domino
    private Board board;// Field to store the board on which the domino will be played
    private Domino domino;// Field to store the domino that will be played
    
    // Constructor to initialize the player, board, and domino
    public PlayDominoCommand(Player player, Board board, Domino domino) {
        this.player = player;
        this.board = board;
        this.domino = domino;
    }

    @Override
    public void execute() {
        player.playDomino(board, domino);// The player plays the domino on the board
    }

      @Override
    public void undo() {
        board.remove(domino); //Remove the domino from the board
        player.addToHand(domino); // Add the domino back to player's hand
    }
}
