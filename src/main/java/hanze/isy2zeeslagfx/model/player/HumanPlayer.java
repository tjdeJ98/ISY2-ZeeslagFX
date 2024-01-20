package hanze.isy2zeeslagfx.model.player;

import hanze.isy2zeeslagfx.model.board.Board;
import hanze.isy2zeeslagfx.model.board.BoardFactory;
import hanze.isy2zeeslagfx.model.game.pieces.FleetManager;
import hanze.isy2zeeslagfx.model.player.strategy.BattleshipStrategy;
import hanze.isy2zeeslagfx.model.player.strategy.PlayerStrategy;

public class HumanPlayer implements Player {
    private final String name;
    private PlayerStrategy strategy;

    public HumanPlayer(String gameType, String playerName)
    {
        this.name = playerName;
        setStrategyType(gameType);
    }

    public void setStrategyType(String gameType)
    {
        if (gameType.equals("Battleships")) {
            this.strategy = new BattleshipStrategy();
        }
    }

    @Override
    public String getName()
    {
        return name;
    }

    public PlayerStrategy getStrategy()
    {
        return this.strategy;
    }
}
