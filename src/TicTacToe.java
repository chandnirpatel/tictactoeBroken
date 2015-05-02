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
        board.display();
    }

    public void start() {
        int turnNumber = 1;
        Player player;
        while (!board.isFull()) {
            if (turnNumber % 2 == 1) player = player1;
            else {player = player2;}

            turn(player, board);
            turnNumber ++;
        }
        board.display();
        printStream.println("Game is a draw");
    }

    public void turn(Player player, Board board) {
        board.display();
        int move = getValidPlayerMove(player, board);
        board.updateBoardValue(move, player.getSymbol());
    }

    private Integer getValidPlayerMove(Player player, Board board){
        int move = player.getMove("Please enter a number between 1 and 9:");

        while ( move < 1 || move > 9 || !board.isEmptyLocation(move) ) {
            move = player.getMove("Location already taken, or invalid move.\n " +
                    "Please enter a different location between 1 and 9:");
        }
        return move;
    }

}
