import java.io.PrintStream;

public class TicTacToe {
    private Board board;
    private Player player1;
    private Player player2;
    private PrintStream printStream;

    public TicTacToe(Board board, Player player1, Player player2, PrintStream printStream) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.printStream = printStream;
    }

    public void start() {
        board.display();
        int turnNumber = 1;
        Player player;
        while (!board.isFull()) {
            if (turnNumber % 2 == 1) player = player1;
            else {player = player2;}

            player.turn();
            turnNumber ++;
        }
        board.display();
        printStream.println("Game is a draw");
    }


}
