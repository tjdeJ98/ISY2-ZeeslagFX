package hanze.isy2zeeslagfx.model.player;

import hanze.isy2zeeslagfx.model.board.Board;
import hanze.isy2zeeslagfx.model.board.BoardFactory;
import hanze.isy2zeeslagfx.model.game.pieces.FleetManager;

public class HumanPlayer implements Player {
    private final String name;
    private final Board board;
    private final Board trackingBoard;
    private final FleetManager fleetManager;

    public HumanPlayer(String gameType, String playerName)
    {
        this.name = playerName;
        this.board = BoardFactory.createBoard(gameType);
        this.trackingBoard = BoardFactory.createBoard(gameType);
        this.fleetManager = new FleetManager();
    }

    public void createShipsForPlayer(int[] newShipsLengths)
    {
        for (int newShipLength : newShipsLengths)
            fleetManager.createNewShip(newShipLength);
    }

    public void placeShip(String startCoordinate, String endCoordinate, int shipId) {
        this.board.shipPlacement(startCoordinate, endCoordinate, shipId);
        this.fleetManager.getShipById(shipId).setPlaced();
        this.fleetManager.getShipById(shipId).setState();
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public Board getBoard()
    {
        return this.board;
    }

    public Board getTrackingBoard()
    {
        return trackingBoard;
    }

    @Override
    public FleetManager getFleetManager()
    {
        return this.fleetManager;
    }
}
