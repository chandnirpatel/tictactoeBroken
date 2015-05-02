import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TicTacToeTest {

    @Test
    public void shouldDisplayBoardWhenStart() {
        Board board = mock(Board.class);
        TicTacToe ticTacToe = new TicTacToe(board);

        ticTacToe.start();

        verify(board).display();
    }
}