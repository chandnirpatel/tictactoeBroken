
public class TicTacToe {


    private Board board;
    private Player player;

    public TicTacToe(Board board, Player player) {

        this.board = board;
        this.player = player;
    }

    public void start() {
        board.display();
        board.updateBoardValue(requestPlayersMove("Please enter a number between 1 and 9:"));
        board.display();
    }

    private Integer requestPlayersMove(String s) {
        Integer move = player.getMove(s);
        return move;
    }
}
