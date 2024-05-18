package patternproject;

public class PlayerDecorator implements GameElement {
    
    protected GameElement decoratedPlayer;

    public PlayerDecorator(GameElement decoratedPlayer) {
        this.decoratedPlayer = decoratedPlayer;
    }

    @Override
    public void start() {
        decoratedPlayer.start();
    }

    @Override
    public void playRound(Player player) {
        decoratedPlayer.playRound(player);
    }

    @Override
    public boolean isGameFinished() {
        return decoratedPlayer.isGameFinished();
    }

    @Override
    public void printFinalScores() {
        decoratedPlayer.printFinalScores();
    }

    @Override
    public void printInfo() {
        decoratedPlayer.printInfo();
    }
         
    
}
