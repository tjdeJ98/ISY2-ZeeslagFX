package hanze.isy2zeeslagfx.model.game;

import hanze.isy2zeeslagfx.model.board.Board;
import hanze.isy2zeeslagfx.model.board.BoardFactory;

public class Game {
    private Board gameBoard;

    public Game(String gameType) {
        this.gameBoard = createBoardForGame(gameType);
    }

    public void setupGame(String gameType) {
        createBoardForGame(gameType);
    }

    private Board createBoardForGame(String gameType) {
        BoardFactory factory = new BoardFactory();
        Board zeeslagBoard = factory.createBoard(gameType);
        return zeeslagBoard;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }
}
