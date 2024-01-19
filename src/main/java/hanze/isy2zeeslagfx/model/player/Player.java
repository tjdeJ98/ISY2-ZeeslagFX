package hanze.isy2zeeslagfx.model.player;

import hanze.isy2zeeslagfx.model.board.Board;
import hanze.isy2zeeslagfx.model.game.pieces.FleetManager;

public interface Player {
    void createShipsForPlayer(int[] newShipLengths);
    String getName();
    Board getBoard();
    FleetManager getFleetManager();
    void placeShip(String startCoordinate, String endCoordinate, int shipId);
}
