package patternproject;

public class SpeedyPlayerDecorator extends PlayerDecorator{
    
    public SpeedyPlayerDecorator(GameElement decoratedPlayer) {
        super(decoratedPlayer);
    }
    
    @Override
    public void playRound(Player player) { 
        SpeedyPlayer(player);
        super.playRound(player);
    }
    
    public void SpeedyPlayer(Player player){
        // Add additional logic for speedy player behavior here
        System.out.println("Speedy Player: " + player.getName() + " tells you to play quickly!");
        
    }
}
