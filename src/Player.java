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

    public String getSymbol() {
        return symbol;
    }

    private Integer readUserInput() {
        Integer move = -1;
        try {
            move = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException nfe){
            move = -1;
        }
        return move;
    }

}
