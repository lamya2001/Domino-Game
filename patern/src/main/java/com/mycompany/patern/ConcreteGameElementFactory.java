
package patternproject;


public class ConcreteGameElementFactory implements GameElementFactory{
    public Game createGame(int startDecision){
         if(startDecision==0){
             return null;
         }
         else if(startDecision==1){
         
            Player player1 = new Player("Player 1");
            Player player2 = new Player("Player 2");
            List<Player> players = new ArrayList<>();
            players.add(player1);
            players.add(player2);
            Board board = Board.getBoard();
            Pack pack = Pack.getPack();

            return new Game(players, board, pack);
        }
        return null;
    }
    @Override
    public Player createPlayer(String name) {
        return new Player(name);
    }

    @Override
    public Board createBoard() {
        return Board.getBoard();
    }

    @Override
    public Pack createPack() {
        return Pack.getPack();
    }
}
