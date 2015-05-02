
public class Main {

    public static void main(String[] args) {
        Board board = new Board(System.out);
        TicTacToe ticTacToe = new TicTacToe(board);
        ticTacToe.start();
    }
}
