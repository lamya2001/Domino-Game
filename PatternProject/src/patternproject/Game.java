package patternproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game implements GameElement {
    private List<GameElement> gameElements;// List to store game elements like players, board, and pack
    private List<Command> commandHistory = new ArrayList<>();// List to store the history of executed commands
    private int historyIndex; // Index to manage undo operations

    // Constructor to initialize the game with players, board, and pack
    public Game(List<Player> players, Board board, Pack pack) {
        gameElements = new ArrayList<>();
        gameElements.addAll(players);// Add all players to the gameElements
        gameElements.add(board);// Add the board to the gameElements
        gameElements.add(pack);// Add the pack to the gameElements
        commandHistory = new ArrayList<>();// Initialize the command history
        historyIndex = 0;// Initialize the history index
        
        // Attach all players as observers to the board
        for (Player player : players) {
            board.attach(player);
        }
    }

    // Start the game by initializing players and their hands
    @Override
    public void start() {
        for (GameElement element : gameElements) {
            if (element instanceof Player) {
                Player player = (Player) element;
                player.drawFromPack(getPack(), 7);// Each player draws 7 dominos from the pack
                System.out.println(player);// Print player's initial hand
            }
        }
        playGame();// Start the main game loop
    }

    // Main game loop to play rounds until the game is finished 
    public void playGame() {
        while (!isGameFinished()) {
            for (GameElement element : gameElements) {
                if (element instanceof Player) {
                    Player player = (Player) element;
                    playRound(player);// Each player plays their round
                }
            }
        }
        // Print the number of remaining dominoes for players after the game is finished
        printFinalScores();
    }

    // Check if the game is finished
    @Override
    public boolean isGameFinished() {
        for (GameElement element : gameElements) {
            if (element instanceof Player) {
                Player player = (Player) element;
                if (player.getHand().isEmpty()) {// Check if any player's hand is empty
                    System.out.println(player.getName() + " has finished! " + player.getName() + " wins!");
                    return true;
                }
            }
        }
        // Check if any player has a valid move left
        List<Player> players = getPlayers();
        for (Player player : players) {
            if (playerHasValidMove(player)) {
                return false;
            }
        }
        System.out.println("No valid moves left. The game is a draw!");
        return true;
    }

    // Check if a player has a valid move
    private boolean playerHasValidMove(Player player) {
        Board board = getBoard();
        for (Domino domino : player.getHand()) {
            if (board.canPlace(domino)) {
                return true;
            }
        }
        return false;
    }

    // Print the number of remaining dominoes
    @Override
    public void printFinalScores() {
        List<Player> players = getPlayers();
        for (Player player : players) {
            System.out.println(player.getName() + "'s remaining dominoes: " + player.getScore());
        }
    }
    
    // Execute a command and add it to the history
    public void executeCommand(Command command) {
        command.execute();
        // Manage command history for undo
        if (historyIndex < commandHistory.size()) {
            commandHistory = commandHistory.subList(0, historyIndex); // Remove any "redo" commands
        }
        commandHistory.add(command);
        historyIndex++;
    }
    
    // Undo the last executed command
    public void undoCommand() {
        if (historyIndex > 0) {
            Command command = commandHistory.get(historyIndex - 1);
            command.undo();
            historyIndex--;
        }
    }

    // Play a round for the given player
    @Override
    public void playRound(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------Your turn, "+player.getName()+"-----------------");
        Board board = getBoard();
        System.out.println("Current state:");
        System.out.println(player.getName() + "'s Hand: " + player.getHand());
        System.out.println(board);
        System.out.println(player.getName() + "'s turn:");
        
        if (!playerHasValidMove(player)) {
            System.out.println(player.getName() + " has no valid moves. Skipping turn.");
            return;
        }
        
        boolean invalidMovePrinted = false; 
        while (!invalidMovePrinted) {
            System.out.println("Select a domino to play by entering its index (0 to " + (player.getHand().size() - 1) + "):");
            int dominoIndex = scanner.nextInt();
            
            if (dominoIndex < 0 || dominoIndex >= player.getHand().size()) {
                System.out.println("Invalid input. Please enter a valid index.");
                 continue; 
            }
            
            Domino selectedDomino = player.getHand().get(dominoIndex);
            if (board.canPlace(selectedDomino)) {
                Command playCommand = new PlayDominoCommand(player, board, selectedDomino);
                executeCommand(playCommand);
                
                System.out.println(board);
                System.out.println("do you want undo? inter \"1 for yes\" or \" 0 for no:\"");
                int undo = scanner.nextInt();
                if (undo == 1) {
                    undoCommand();
                    // Print current state after undo
                    System.out.println("Undo performed. Current state:");
                    System.out.println(player.getName() + "'s Hand: " + player.getHand());
                    System.out.println(board);
                    continue; // Continue loop to prompt player again
                }

                System.out.println(player.getName() + " plays " + selectedDomino);
                System.out.println(board);
                break; 
            } else {
                if (!invalidMovePrinted) {
                    System.out.println("Invalid move. Cannot place the selected domino on the board.");
                    invalidMovePrinted = true; 
                }
            }

        }
        
        // Update and print scores after each round
        List<Player> players = getPlayers();
        for (Player p : players) {
            p.updateScore();
            System.out.println(p.getName() + "'s remaining dominoes: " + p.getScore());
        } 
        
            int useSpeedyPlayerDecorator = 0; 
            System.out.println("Do you want to tell the next player to speed up?inter \"1 for yes\" or \" 0 for no:\"");
            useSpeedyPlayerDecorator=scanner.nextInt();
            if(useSpeedyPlayerDecorator==1){
                GameElement playerSpeed=new SpeedyPlayerDecorator(player);
                playerSpeed.playRound(player);   
            }
      
    }

    // Retrieve the board from the game elements
    private Board getBoard() {
        for (GameElement element : gameElements) {
            if (element instanceof Board) {
                return (Board) element;
            }
        }
        throw new IllegalStateException("No Board found");
    }
    
    // Retrieve the pack from the game elements
    private Pack getPack() {
        for (GameElement element : gameElements) {
            if (element instanceof Pack) {
                return (Pack) element;
            }
        }
        throw new IllegalStateException("No Pack found");
    }
    
    // Retrieve the players from the game elements
    private List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        for (GameElement element : gameElements) {
            if (element instanceof Player) {
                players.add((Player) element);
            }
        }
        return players;
    }
    
    // Print information about the game
    @Override
    public void printInfo() {
        System.out.println("Game Information:");
        for (GameElement element : gameElements) {
            element.printInfo();
        }
    }
}