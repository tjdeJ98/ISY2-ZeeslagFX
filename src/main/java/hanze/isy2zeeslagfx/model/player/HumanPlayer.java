package hanze.isy2zeeslagfx.model.player;

import hanze.isy2zeeslagfx.model.board.Board;
import hanze.isy2zeeslagfx.model.board.BoardFactory;

public class HumanPlayer implements Player {
    private final String name;
    private final String gameType;
    private Board board;

    public HumanPlayer(String name, String gameType) {
        this.name = name;
        this.gameType = gameType;
        this.board = BoardFactory.createBoard(gameType);
    }

    @Override
    public String getName() {
        return name;
    }
}
