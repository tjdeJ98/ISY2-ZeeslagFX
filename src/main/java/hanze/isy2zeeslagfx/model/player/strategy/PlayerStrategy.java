package hanze.isy2zeeslagfx.model.player.strategy;

import hanze.isy2zeeslagfx.model.board.Board;

public interface PlayerStrategy {
    void performAction(String... args);
    Board getTrackingBoard();
}
