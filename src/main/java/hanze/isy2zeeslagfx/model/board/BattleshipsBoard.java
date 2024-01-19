package hanze.isy2zeeslagfx.model.board;

import java.util.Arrays;

public class BattleshipsBoard implements Board {
    private final int width = 8;
    private final int height = 8;

    protected char[][] board = new char[width][height];

    public BattleshipsBoard() {

    }

    protected char[][] fillBoard(Board board) {
        char[][] gameBoard = this.board;
        int maxPosition = 8;

        for(int i = 0; i < maxPosition; i++) {
            char[] row = gameBoard[i];
            Arrays.fill(row, '-');
        }

        return this.board;
    }

    protected void printBoard() {
        for(int row = 0; row < width; ++row) {
            for(int col = 0; col < height; ++col) {
                System.out.print(this.board[row][col]);
                System.out.print("  ");
                if (col == 7) {
                    System.out.println();
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
