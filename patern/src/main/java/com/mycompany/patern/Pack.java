package com.mycompany.patern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pack {
   private List<Domino> dominos;
    private static Pack pack = null;
    
    //constructor
    Pack() {
        dominos = new ArrayList<>();
        //Create dominoes then put them in the domino pack
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                dominos.add(new Domino(i, j));
            }
        }
        shuffle();//Make the dominos list random
    }
    
    public static Pack getPack() {
     if(pack == null) {
        pack = new Pack();   
    }
       return pack;
       
    }
    
    //check if the domino's pack is empty
    public boolean isEmpty() {
        return dominos.isEmpty();
    }
    
    //Make the dominos list random
    public void shuffle() {
        Collections.shuffle(dominos);
    }
    
    //Take dominoes from the list of random dominoes
    public Domino draw() {
         //check if the list is not empty then return the first domino
        if (!dominos.isEmpty()) {
            return dominos.remove(0);
        }
        return null;//return null if empty 
    } 
}
