package hanze.isy2zeeslagfx.model.player;

import hanze.isy2zeeslagfx.model.ai.AIStrategy;
import hanze.isy2zeeslagfx.model.ai.BattleshipsAIStrategy;
import hanze.isy2zeeslagfx.model.board.BattleshipsBoard;
import hanze.isy2zeeslagfx.model.board.Board;
import hanze.isy2zeeslagfx.model.board.BoardFactory;
import hanze.isy2zeeslagfx.model.game.pieces.FleetManager;
import hanze.isy2zeeslagfx.model.player.strategy.BattleshipStrategy;
import hanze.isy2zeeslagfx.model.player.strategy.PlayerStrategy;

public class AIPlayer implements Player {
    private final String name;
    private PlayerStrategy strategy;
    private AIStrategy aiStrategy;

    public AIPlayer(String gameType, String playerName)
    {
        this.name = playerName;
        setStrategyType(gameType);
    }

    public void setStrategyType(String gameType)
    {
        if (gameType.equals("Battleships")) {
            this.strategy = new BattleshipStrategy();
            this.aiStrategy = new BattleshipsAIStrategy();
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

    public AIStrategy getAiStrategy() {
        return aiStrategy;
    }
}
