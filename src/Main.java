import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {
        Board board = new Board(System.out);
        PrintStream printStream = new PrintStream(System.out);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Player player = new Player(printStream, bufferedReader);
        TicTacToe ticTacToe = new TicTacToe(board, player);
        ticTacToe.start();
    }
}
