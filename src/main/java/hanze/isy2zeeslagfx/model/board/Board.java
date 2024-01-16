package hanze.isy2zeeslagfx.model.board;

import java.util.Arrays;

public abstract class Board {
    protected final int gameBoardLength = 8;
    protected char[][] board = new char[gameBoardLength][gameBoardLength];

    Board() {
    }

    protected char[][] fillBoard(Board board) {
        char[][] gameBoard = this.board;
        int maxPosition = gameBoardLength;

        for(int i = 0; i < maxPosition; i++) {
            char[] row = gameBoard[i];
            Arrays.fill(row, '-');
        }

        return this.board;
    }

    protected void printBoard() {
        for(int row = 0; row < 8; ++row) {
            for(int col = 0; col < 8; ++col) {
                System.out.print(this.board[row][col]);
                System.out.print("  ");
                if (col == 7) {
                    System.out.println();
                }
            }
        }

    }
}
