import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class TicTacToeTest {
    private Board board;
    private Player player1;
    private Player player2;
    private PrintStream printStream;
    private TicTacToe ticTacToe;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        ticTacToe = new TicTacToe(board, player1, player2, printStream);
    }

    @Test
    public void shouldDisplayBoardWhenStart() {
        when(board.isFull()).thenReturn(true);

        ticTacToe.start();

        verify(board, atLeast(1)).display();
    }

    @Test
    public void shouldHavePlayerOneTakeATurnWhenPlayingGame() {

        ticTacToe.start();

        verify(player1, atLeastOnce()).turn();
    }

    @Test
    public void shouldHavePlayerTwoTakeATurnWhenPlayingGame() {
        ticTacToe.start();
        verify(player2, atLeastOnce()).turn();
    }

    @Test
    public void shouldDisplayGameIsADrawWhenBoardIsFull() {
        when(board.isFull()).thenReturn(true);

        ticTacToe.start();

        verify(printStream).println("Game is a draw");
    }

    @Test
    public void shouldDisplayBoardWhenBoardIsFull() {
        when(board.isFull()).thenReturn(true);

        ticTacToe.start();

        verify(board, atLeastOnce()).display();
    }


}