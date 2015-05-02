import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class TicTacToeTest {
    private Board board;
    TicTacToe ticTacToe;
    Player player1;
    private Player player2;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        ticTacToe = new TicTacToe(board, player1, player2);
    }

    @Test
    public void shouldDisplayBoardWhenStart() {

        ticTacToe.start();

        verify(board, atLeast(1)).display();
    }

    @Test
    public void shouldAskPlayer1ForMove() {

        ticTacToe.start();

        verify(player1, atLeastOnce()).getMove(anyString());
    }


    @Test
    public void shouldAskPlayer2ForMoveWhenPlaying() {
        when(player2.getMove(anyString())).thenReturn(1).thenReturn(2);

        ticTacToe.start();

        verify(player2, atLeastOnce()).getMove(anyString());
    }
}