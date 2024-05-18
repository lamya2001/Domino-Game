package patternproject;

import java.util.ArrayList;
import java.util.List;

public class ConcreteGameElementFactory {
    
    //Factory Method to create a game based on the user selection 
    
    public GameElement createGame(int startDecision){
        
        // If the start decision is 0, return null (do not start the game)
         if(startDecision==0){
             return null;
         }
         // If the start decision is 1, proceed to create the game
         else if(startDecision==1){
             
            // Creating two players
            Player player1 = new Player("Player 1");
            Player player2 = new Player("Player 2");
            
            // Adding players to a list
            List<Player> players = new ArrayList<>();
            players.add(player1);
            players.add(player2);
            
            // Getting the singleton instance of the board
            Board board = Board.getBoard();
            
            // Getting the singleton instance of the pack
            Pack pack = Pack.getPack();
            
            // Creating and returning a new game instance with the players, board, and pack
            return new Game(players, board, pack);
        }
        // If the input is not 0 or 1, return null
        return null;
    }
    // Method to create a player with the specified name
    public Player createPlayer(String name) {
        return new Player(name);
    }
    
    // Method to get the singleton instance of the board
    public Board createBoard() {
        return Board.getBoard();
    }
    
    // Method to get the singleton instance of the pack
    public Pack createPack() {
        return Pack.getPack();
    }
}