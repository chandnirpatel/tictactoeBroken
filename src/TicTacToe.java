public class TicTacToe {
    private Board board;
    private Player player1;
    private Player player2;

    public TicTacToe(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        board.display();
    }

    public void start() {
        turn(player1, board);
        turn(player2, board);
    }

    public void turn(Player player, Board board) {
        int move = getValidPlayerMove(player, board);
        board.updateBoardValue(move, player.getSymbol());
        board.display();
    }

    private Integer getValidPlayerMove(Player player, Board board){
        int move = player.getMove("Please enter a number between 1 and 9:");
        while ( move < 1 || move > 9 || !board.isEmptyLocation(move) ) {
            move = player.getMove("Location already taken, or invalid move.\n " +
                    "Please enter a different location between 1 and 9:");
        }
        return move;
    }

}
