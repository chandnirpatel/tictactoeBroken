import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class TicTacToeTest {
    private Board board;
    private Player player1;
    private Player player2;
    private PrintStream printStream;
    private TicTacToe ticTacToe;
    private Board mockBoard;
    private TicTacToe ticTacToeWithMockBoard;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = new Board(System.out);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        ticTacToe = new TicTacToe(board, player1, player2, printStream);

        mockBoard = mock(Board.class);
        ticTacToeWithMockBoard = new TicTacToe(mockBoard, player1, player2, printStream);
    }

    @Test
    public void shouldDisplayBoardWhenStart() {

        verify(mockBoard, atLeast(1)).display();
    }

    @Test
    public void shouldDisplayGameIsADrawWhenBoardIsFull() {
        when(mockBoard.isFull()).thenReturn(true);

        ticTacToeWithMockBoard.start();

        InOrder inOrder = inOrder(mockBoard, printStream);

        inOrder.verify(mockBoard).isFull();
        inOrder.verify(printStream).println("Game is a draw");
    }

    @Test
    public void shouldDisplayBoardWhenBoardIsFull() {
        board = mock(Board.class);
        when(board.isFull()).thenReturn(true);
        TicTacToe ticTacToeWithMockBoard = new TicTacToe(board, player1, player2, printStream);

        ticTacToeWithMockBoard.start();

        InOrder inOrder = inOrder(board, board);

        inOrder.verify(board).isFull();
        inOrder.verify(board).display();
    }

    @Test
    public void shouldAskPlayerForMove() {
        when(player1.getMove(anyString())).thenReturn(1);

        ticTacToe.turn(player1, board);

        verify(player1, atLeastOnce()).getMove(anyString());
    }

    @Test
    public void shouldKeepPlayingAlternatePlayersUntilBoardIsFull() {
        when(player1.getMove(anyString())).thenReturn(1, 3, 5, 7, 9);
        when(player1.getSymbol()).thenReturn("X ", "X ", "X ", "X ", "X ");
        when(player2.getMove(anyString())).thenReturn(2, 4, 6, 8);
        when(player2.getSymbol()).thenReturn("O ", "O ", "O ", "O ");


        ticTacToe.start();

        assertTrue(board.isFull());
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