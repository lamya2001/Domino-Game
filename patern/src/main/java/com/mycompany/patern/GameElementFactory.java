package patternproject;

public interface GameElementFactory {
    Player createPlayer(String name);
    Board createBoard();
    Pack createPack();
    Game createGame(int startDecision);
}
