package hanze.isy2zeeslagfx.model.player;

import hanze.isy2zeeslagfx.model.board.Board;
import hanze.isy2zeeslagfx.model.board.BoardFactory;
import hanze.isy2zeeslagfx.model.game.pieces.FleetManager;

public class AIPlayer implements Player {
    private final String name;
    private final Board board;
    private final FleetManager fleetManager;

    public AIPlayer(String gameType, String playerName)
    {
        this.name = playerName;
        this.board = BoardFactory.createBoard(gameType);
        this.fleetManager = new FleetManager();
    }

    public void createShipsForPlayer(int[] newShipLengths) {
        for (int newShipLength : newShipLengths)
            fleetManager.createNewShip(newShipLength);
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

    @Override
    public FleetManager getFleetManager()
    {
        return fleetManager;
    }
}
