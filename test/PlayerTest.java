import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class PlayerTest {
    @Test
    public void shouldGiveMoveLocationWhenPrompted() throws IOException {
        PrintStream printStream = new PrintStream(System.out);
        BufferedReader bufferedReader = mock(BufferedReader.class);
        Player player = new Player(printStream, bufferedReader, "X ");
        when(bufferedReader.readLine()).thenReturn("1");

        player.getMove("");

        verify(bufferedReader).readLine();
    }

}