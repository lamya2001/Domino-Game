
package patternproject;

import java.util.ArrayList;
import java.util.List;
    
  public class Tester {
    public static void main(String[] args) {
        GameElementFactory factory = new ConcreteGameElementFactory();
        Player player1 = factory.createPlayer("Player 1");
        Player player2 = factory.createPlayer("Player 2");
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        Board board = factory.createBoard();
        Pack pack = factory.createPack();

        Game game = new Game(players, board, pack);
        game.start();
    }
}
