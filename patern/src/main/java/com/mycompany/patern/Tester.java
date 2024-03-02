package com.mycompany.patern;

import java.util.ArrayList;
import java.util.List;
        
public class Tester {

    public static void main(String[] args) {
        
        //create players
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        
        //create a list and add the players to it
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        
        //create a game for these players
        Game game = new Game(players);
        game.start();//Start the game
    
    }
    
}

    

