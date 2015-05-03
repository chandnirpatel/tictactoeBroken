import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {
    private PrintStream printStream;
    private Board board;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldDisplayBoard() {
        board.display();

        verify(printStream).println("  |  |  \n--------\n  |  |  \n--------\n  |  |  ");
    }

    @Test
    public void shouldDisplayXInTopLeftWhenUpdateBoardForPosition1() {
        board.updateBoardValue(1, "X ");
        board.display();

        verify(printStream).println("X |  |  \n" +
                                    "--------\n" +
                                    "  |  |  \n" +
                                    "--------\n" +
                                    "  |  |  ");
    }

    @Test
    public void shouldDisplayXInTopMiddleWhenUpdateBoardForPosition2() {
        board.updateBoardValue(2, "X ");
        board.display();

        verify(printStream).println("  |X |  \n" +
                                    "--------\n" +
                                    "  |  |  \n" +
                                    "--------\n" +
                                    "  |  |  ");
    }

    @Test
    public void shouldDisplayOInTopLeftWhenPlayer2ChoosesPosition1() {
        board.updateBoardValue(1, "O ");
        board.display();

        verify(printStream).println("O |  |  \n" +
                "--------\n" +
                "  |  |  \n" +
                "--------\n" +
                "  |  |  ");
    }

    @Test
    public void shouldBeTrueWhenBoardIsFull() {
        for (int location = 1; location < 10; location++) {
            board.updateBoardValue(location, "X ");
        }

        assertTrue(board.isFull());
    }

}