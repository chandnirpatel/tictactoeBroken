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
        board = new Board(System.out);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        ticTacToe = new TicTacToe(board, player1, player2);
    }

    @Test
    public void shouldDisplayBoardWhenStart() {
        board = mock(Board.class);
        TicTacToe ticTacToeWithMockBoard = new TicTacToe(board, player1, player2);

        verify(board, atLeast(1)).display();
    }

    @Test
    public void shouldAskPlayerForMove() {
        when(player1.getMove(anyString())).thenReturn(1);

        ticTacToe.turn(player1,board);

        verify(player1, atLeastOnce()).getMove(anyString());
    }


    @Test
    public void shouldAskPlayer2ForMoveWhenPlaying() {
        when(player1.getMove(anyString())).thenReturn(1);
        when(player2.getMove(anyString())).thenReturn(2);

        ticTacToe.start();

        verify(player2, atLeastOnce()).getMove(anyString());
    }

    @Test
    public void shouldAskForValidLocationWhenPlayerGivesInvalidInput() {
        when(player1.getMove(anyString())).thenReturn(10).thenReturn(1);

        ticTacToe.turn(player1, board);

        verify(player1, atLeast(2)).getMove(anyString());
    }

    @Test
    public void shouldAskForDifferentLocationWhenPlayerGivesUsedLocation() {
        int takenLocation = 1;
        board.updateBoardValue(takenLocation, "X ");
        when(player1.getMove(anyString())).thenReturn(takenLocation).thenReturn(2);

        ticTacToe.turn(player1, board);

        verify(player1).getMove(contains("Location already taken"));
    }
}