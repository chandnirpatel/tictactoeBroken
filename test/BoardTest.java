import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    @Test
    public void shouldDisplayBoard() {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);

        board.display();

        verify(printStream).println("   |   |\n---------\n   |   |\n---------\n   |   |");


    }


}