package hanze.isy2zeeslagfx.model.board;

import java.util.Arrays;

public class BattleshipsBoard implements Board {
    private final int boardSize = 8;
    private final BattleshipCell[][] board;

    public BattleshipsBoard()
    {
        this.board = new BattleshipCell[boardSize][boardSize];
        this.initializeBoard();
        this.printBoard();
    }

    public void initializeBoard()
    {
        for (int row=0; row<boardSize; row++) {
            for (int col=0; col<boardSize; col++) {
                board[row][col] = new BattleshipCell();
            }
        }
    }

    private void printBoard()
    {
        for (int i=0; i<board.length; i++) {
            System.out.printf(Arrays.toString(board[i]));
        }
    }

    public BattleshipCell[][] getBoard() {
        return this.board;
    }
}
