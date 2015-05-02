import java.io.PrintStream;

public class Board {
    private PrintStream printStream;

    public Board(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void display() {
        printStream.println("   |   |\n---------\n   |   |\n---------\n   |   |");
    }
}
