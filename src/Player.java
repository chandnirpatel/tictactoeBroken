import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Player {
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;


    public Player(PrintStream printStream, BufferedReader bufferedReader) {

        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public Integer getMove(String prompt) {
        printStream.println(prompt);
        Integer move = readUserInput();
        return move;
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
