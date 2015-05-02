import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private PrintStream printStream;

    public List<String> getBoardValues() {
        return boardValues;
    }

    private List<String> boardValues = new ArrayList<>();

    public Board(PrintStream printStream) {
        this.printStream = printStream;
        clearBoard();
    }

    private void clearBoard() {
        for (int location = 0; location < 10; location++) {
            boardValues.add("  ");
            if (location == 0) boardValues.set(0, "");
        }
    }

    public void display() {
        printStream.println(boardValues.get(1) + "|" + boardValues.get(2) + "|" + boardValues.get(3) +
                            "\n--------\n" +
                            boardValues.get(4) + "|" + boardValues.get(5) + "|" + boardValues.get(6) +
                            "\n--------\n" +
                            boardValues.get(7) + "|" + boardValues.get(8) + "|" + boardValues.get(9));
    }

    public void updateBoardValue(int location, String symbol) {
        boardValues.set(location, symbol);
    }

    public boolean isEmptyLocation(int move) {
        return boardValues.get(move).equals("  ");
    }

    public boolean isFull() {
        boolean full = true;
        for (String boardValue : boardValues) {
            if (boardValue.equals("  ")) full = false;
        }
        return full;
    }


}
