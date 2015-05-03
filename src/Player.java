import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Player {
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final String symbol;

    public Player(PrintStream printStream, BufferedReader bufferedReader, String symbol) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.symbol = symbol;
    }

    public Integer getMove(String prompt) {
        printStream.println(prompt);
        return readUserInput();
    }

    private Integer readUserInput() {
        Integer move = -1;
        try {
            move = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return move;
    }

    public void turn(Board board) {
        board.display();
        int move = getValidPlayerMove(board);
        board.updateBoardValue(move, symbol);
    }

    private Integer getValidPlayerMove(Board board){
        int move = getMove("Please enter a number between 1 and 9:");

        while (!board.isEmptyLocation(move)) {
            move = getMove("Location already taken\n " +
                    "Please enter a different location between 1 and 9:");
        }
        return move;
    }
}
