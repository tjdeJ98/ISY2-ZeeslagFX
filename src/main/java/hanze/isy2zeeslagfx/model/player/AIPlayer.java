package hanze.isy2zeeslagfx.model.player;

import hanze.isy2zeeslagfx.model.board.Board;

public class AIPlayer implements Player {
    private final String name;
    private final String gameType;
    private Board board;

    public AIPlayer(String name, String gameType)
    {
        this.name = name;
        this.gameType = gameType;
    }

    @Override
    public String getName() {
        return name;
    }
}
