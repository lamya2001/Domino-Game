package com.mycompany.patern;

import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private Pack pack;
    private List<Player> players;
    
    //constructor
    public Game(List<Player> players) {
        this.board = new Board();//Create a new board from the Board class
        this.pack = new Pack();//Create a new domino pack from the Pack class
        this.players = players;//Store the player list that gets
    }
    
    //Start the game by giving each player 7 dominoes in their hands from the pack 
    public void start() {
        for (Player player : players) {
            player.drawFromPack(pack, 7);
            System.out.println(player);//Print each player's Domino's collection
        }
        //Start the game rounds
        playGame();
    }
    
    //Start the game rounds
    public void playGame() {
        while (!isGameFinished()) {
            for (Player player : players) {
                playRound(player);// Give each player rounds until the game is finished
            }
        }
        printFinalScores();//After the game is finished print the final score
    }

    private boolean isGameFinished() {
        //Check if players finish their domino list
        for (Player player : players) {
            if (player.getHand().isEmpty()) {
                //The first player who finishes his domino list is the winner
                System.out.println(player.getName() + " has finished! " + player.getName() + " wins!");
                return true;
            }
        }
        
        //Check if the domino tiles the players have valid to play with them.
        for (Player player : players) {
            if (playerHasValidMove(player)) {
                return false;
            }
        }
        
        System.out.println("No valid moves left. The game is a draw!");
        return true;
    }
    
    //Check if the domino tiles the players have valid to play with them.
    private boolean playerHasValidMove(Player player) {
        for (Domino domino : player.getHand()) {
            if (board.canPlace(domino)) {
                return true;
            }
        }
        return false;
    }
    
    //print Final Scores for each player
    private void printFinalScores() {
        for (Player player : players) {
            System.out.println(player.getName() + "'s final score: " + player.getScore());
        }
    }
    
    
    public void playRound(Player player) {
        Scanner scanner = new Scanner(System.in);

        // Display current state 
        System.out.println("Current state:");
        System.out.println(player.getName() + "'s Hand: " + player.getHand());
        System.out.println(board);

        System.out.println(player.getName() + "'s turn:");
        //Back if the player doesn't have a valid move
        if (!playerHasValidMove(player)) {
            System.out.println(player.getName() + " has no valid moves. Skipping turn.");
            return;
        }

        // Ask the user to choose a domino to play
        System.out.println("Select a domino to play by entering its index (0 to " + (player.getHand().size() - 1) + "):");
        int dominoIndex = scanner.nextInt();

        // Validate the input
        if (dominoIndex < 0 || dominoIndex >= player.getHand().size()) {
            System.out.println("Invalid input. Please enter a valid index.");
            return;
        }
        Domino selectedDomino = player.getHand().get(dominoIndex);

        // Attempt to play the selected domino
        if (board.canPlace(selectedDomino)) {
            player.playDomino(board, selectedDomino);
            System.out.println(player.getName() + " plays " + selectedDomino);
            System.out.println(board);

            // Check for a double domino to give the player an extra turn
            if (selectedDomino.getSide1() == selectedDomino.getSide2()) {
                System.out.println(player.getName() + " played a double domino and gets an extra turn!");
                playRound(player);
            }
        } else {
            System.out.println("Invalid move. Cannot place the selected domino on the board.");
        }

        for (Player p : players) {
            p.updateScore();
            System.out.println(p.getName() + "'s score: " + p.getScore());
        }

        for (Player p : players) {
            System.out.println(player.getName() + "'s final hand: " + player.getHand());
        }
    }
      
}
