
package patternproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Game implements GameElement {
    private List<GameElement> gameElements;

    public Game(List<Player> players, Board board, Pack pack) {
        gameElements = new ArrayList<>();
        gameElements.addAll(players);
        gameElements.add(board);
        gameElements.add(pack);
    }

    @Override
    public void start() {
        for (GameElement element : gameElements) {
            if (element instanceof Player) {
                Player player = (Player) element;
                player.drawFromPack(getPack(), 7);
                System.out.println(player);
            }
        }
        playGame();
    }

    public void playGame() {
        while (!isGameFinished()) {
            for (GameElement element : gameElements) {
                if (element instanceof Player) {
                    Player player = (Player) element;
                    playRound(player);
                }
            }
        }
        printFinalScores();
    }

    @Override
    public boolean isGameFinished() {
        for (GameElement element : gameElements) {
            if (element instanceof Player) {
                Player player = (Player) element;
                if (player.getHand().isEmpty()) {
                    System.out.println(player.getName() + " has finished! " + player.getName() + " wins!");
                    return true;
                }
            }
        }

        List<Player> players = getPlayers();
        for (Player player : players) {
            if (playerHasValidMove(player)) {
                return false;
            }
        }

        System.out.println("No valid moves left. The game is a draw!");
        return true;
    }

    private boolean playerHasValidMove(Player player) {
        Board board = getBoard();
        for (Domino domino : player.getHand()) {
            if (board.canPlace(domino)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void printFinalScores() {
        List<Player> players = getPlayers();
        for (Player player : players) {
            System.out.println(player.getName() + "'s final score: " + player.getScore());
        }
    }

    @Override
    public void playRound(Player player) {
        Scanner scanner = new Scanner(System.in);
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
                player.playDomino(board, selectedDomino);
                System.out.println(player.getName() + " plays " + selectedDomino);
                System.out.println(board);
                if (selectedDomino.getSide1() == selectedDomino.getSide2()) {
                    System.out.println(player.getName() + " played a double domino and gets an extra turn!");
                    playRound(player);
                }
                break; 
            } else {
                if (!invalidMovePrinted) {
                    System.out.println("Invalid move. Cannot place the selected domino on the board.");
                    invalidMovePrinted = true; 
                }
            }
    }

        List<Player> players = getPlayers();
        for (Player p : players) {
            p.updateScore();
            System.out.println(p.getName() + "'s score: " + p.getScore());
        }

        for (Player p : players) {
            System.out.println(p.getName() + "'s final hand: " + p.getHand());
        }
    
    }

    private Board getBoard() {
        for (GameElement element : gameElements) {
            if (element instanceof Board) {
                return (Board) element;
            }
        }
        throw new IllegalStateException("No Board found");
    }

    private Pack getPack() {
        for (GameElement element : gameElements) {
            if (element instanceof Pack) {
                return (Pack) element;
            }
        }
        throw new IllegalStateException("No Pack found");
    }

    private List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        for (GameElement element : gameElements) {
            if (element instanceof Player) {
                players.add((Player) element);
            }
        }
        return players;
    }
}
