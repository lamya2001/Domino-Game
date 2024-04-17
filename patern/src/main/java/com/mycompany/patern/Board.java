package com.mycompany.patern;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Domino> playedDominos;
    private static Board board = null;
    
    
    //constructor 
    Board() {
        this.playedDominos = new ArrayList<>();
    }
    
    public static Board getBoard() {
     if(board == null) {
        board = new Board();   
    }
       return board;
       
    }
    
    //check if the selected domino piece is available to place on the board
    public boolean canPlace(Domino domino) {
        
        //if the board is empty any piece could place
        if (playedDominos.isEmpty()) {
            return true;
        }
        
        //take head and tail values for the placed domino
        int head = playedDominos.get(0).getSide1();
        int tail = playedDominos.get(playedDominos.size() - 1).getSide2();
        
        //return whether the head and tail values for the selected domino match the head and tail values for the placed domino
        return domino.getSide1() == head || domino.getSide2() == head ||
                domino.getSide1() == tail || domino.getSide2() == tail;
    }
    
    //Place the domino on the board
    public void place(Domino domino) {
        if (playedDominos.isEmpty()) {
            playedDominos.add(domino);
        } 
        //check if the domino sides are equal tail or head for the first or last dominos on the board
        else if (domino.getSide1() == playedDominos.get(0).getSide1()) {
            playedDominos.add(0, domino);
        } else if (domino.getSide2() == playedDominos.get(0).getSide1()) {
            playedDominos.add(0, new Domino(domino.getSide2(), domino.getSide1()));
        } else if (domino.getSide1() == playedDominos.get(playedDominos.size() - 1).getSide2()) {
            playedDominos.add(domino);
        } else if (domino.getSide2() == playedDominos.get(playedDominos.size() - 1).getSide2()) {
            playedDominos.add(new Domino(domino.getSide2(), domino.getSide1()));
        }
    }
    
    //Print the board
    @Override
    public String toString() {
        return "Board: " + playedDominos;
    }
}
