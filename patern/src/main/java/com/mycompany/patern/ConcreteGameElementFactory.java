
package patternproject;


public class ConcreteGameElementFactory implements GameElementFactory{
    @Override
    public Player createPlayer(String name) {
        return new Player(name);
    }

    @Override
    public Board createBoard() {
        return new Board();
    }

    @Override
    public Pack createPack() {
        return new Pack();
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void playRound(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean isGameFinished() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void printFinalScores() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
