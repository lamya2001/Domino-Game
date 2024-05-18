package patternproject;

public class Domino {
    private int side1;// Field to store the value of the first side of the domino
    private int side2; // Field to store the value of the second side of the domino
    
    
    // Constructor to initialize the domino with specific values for side1 and side2
    public Domino(int side1, int side2) {
        this.side1 = side1;
        this.side2 = side2;
    }
        
    // Getter method for side1
    public int getSide1() {
        return side1;
    }
    
    // Getter method for side2
    public int getSide2() {
        return side2;
    }
    
    // Override the toString() method to return a string representation of the domino
    @Override
    public String toString() {
        return "[" + side1 + "|" + side2 + "]";
    }
    
    // Override the equals() method to compare two dominos for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) // Check if the current object is being compared with itself
            return true;
        if (o == null || getClass() != o.getClass())// Check if the object is null or not of the same class
            return false;

        Domino domino = (Domino) o; // Cast the object to Domino

        if (side1 != domino.side1) // Compare side1 values
            return false;
        return side2 == domino.side2;// Compare side2 values
    }

    // Override the hashCode() method to provide a hash code for the domino object
    @Override
    public int hashCode() {
        int result = side1;// Initialize the result with the value of side1
        result = 31 * result + side2;// Multiply the result by 31 and add the value of side2
        return result;// Return the calculated hash code
    }
}
