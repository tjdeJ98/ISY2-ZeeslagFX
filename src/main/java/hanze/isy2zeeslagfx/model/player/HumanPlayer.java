package hanze.isy2zeeslagfx.model.player;

import hanze.isy2zeeslagfx.model.board.Board;
import hanze.isy2zeeslagfx.model.board.BoardFactory;
import hanze.isy2zeeslagfx.model.game.pieces.FleetManager;
import hanze.isy2zeeslagfx.model.game.pieces.Ship;

public class HumanPlayer implements Player {
    private final String name;
    private Board board;
    private FleetManager fleetManager;

    public HumanPlayer(String gameType, String playerName)
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
        return this.fleetManager;
    }
}
