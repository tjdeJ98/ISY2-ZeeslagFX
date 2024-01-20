package hanze.isy2zeeslagfx.model.player;

import hanze.isy2zeeslagfx.model.board.Board;
import hanze.isy2zeeslagfx.model.game.pieces.FleetManager;
import hanze.isy2zeeslagfx.model.player.strategy.PlayerStrategy;

public interface Player {
    String getName();
    void setStrategyType(String gameType);
    PlayerStrategy getStrategy();
}
