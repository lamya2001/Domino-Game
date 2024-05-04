
package patternproject;


public class Domino {
    private int side1;
    private int side2;
    
    //constructor
    public Domino(int side1, int side2) {
        //Create each domino based on the values received from the pack
        this.side1 = side1;
        this.side2 = side2;
    }
    
    //Get the Side 1 of the domino piece
    public int getSide1() {
        return side1;
    }
    
    // Get the Side 2 of the domino piece
    public int getSide2() {
        return side2;
    }

    //Print the domino piece with his two side
    @Override
    public String toString() {
        return "[" + side1 + "|" + side2 + "]";
    }
}
