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
    public void shouldDisplayBoardInCorrectFormat() {
        board.display();

        verify(printStream).println("  |  |  \n--------\n  |  |  \n--------\n  |  |  ");
    }

    @Test
    public void shouldDisplayXInTopLeftWhenUpdateBoardForCell1() {
        board.updateBoardValue(1, "X ");
        board.display();

        verify(printStream).println("X |  |  \n" +
                                    "--------\n" +
                                    "  |  |  \n" +
                                    "--------\n" +
                                    "  |  |  ");
    }

    @Test
    public void shouldDisplayXInTopMiddleWhenUpdateBoardForCell2() {
        board.updateBoardValue(2, "X ");
        board.display();

        verify(printStream).println("  |X |  \n" +
                                    "--------\n" +
                                    "  |  |  \n" +
                                    "--------\n" +
                                    "  |  |  ");
    }

    @Test
    public void shouldDisplayOInTopLeftWhenPlayer2ChoosesCell1() {
        board.updateBoardValue(1, "O ");
        board.display();

        verify(printStream).println("O |  |  \n" +
                "--------\n" +
                "  |  |  \n" +
                "--------\n" +
                "  |  |  ");
    }

    @Test
    public void shouldBeAbleToConfirmIfACellIsTakenOrEmpty() {
        board.updateBoardValue(1, "O ");

        assertFalse(board.isEmptyLocation(1));
        assertTrue(board.isEmptyLocation(2));

    }

    @Test
    public void shouldBeTrueWhenBoardIsFull() {
        for (int location = 1; location < 10; location++) {
            board.updateBoardValue(location, "X ");
        }

        assertTrue(board.isFull());
    }

}