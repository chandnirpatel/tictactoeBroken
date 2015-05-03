import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class PlayerTest {

    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldGiveMoveLocationWhenPrompted() throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        Board board = mock(Board.class);
        Player player = new Player(printStream, bufferedReader, "X ", board);
        when(bufferedReader.readLine()).thenReturn("1");

        player.turn();

        verify(printStream).println(contains(String.valueOf(equalToIgnoringCase("Enter a number between 1 and 9"))));
        verify(bufferedReader).readLine();

    }

    @Test
    public void shouldDisplayMessageWhenPlayerMovesIntoATakenCell() {


    }
}


