import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TicTacToeTest {
    private Board board;
    TicTacToe ticTacToe;
    Player player;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        player = mock(Player.class);
        ticTacToe = new TicTacToe(board, player);
    }

    @Test
    public void shouldDisplayBoardWhenStart() {

        ticTacToe.start();

        verify(board, atLeast(1)).display();
    }

    @Test
    public void shouldAskPlayerForMove() {
        String prompt = "Enter a number between 1 and 9:";

        ticTacToe.start();

        verify(player).getMove(anyString());
    }
}