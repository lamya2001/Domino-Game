
package patternproject;

public interface GameElementFactory extends GameElement{
    Player createPlayer(String name);
    Board createBoard();
    Pack createPack();
}
