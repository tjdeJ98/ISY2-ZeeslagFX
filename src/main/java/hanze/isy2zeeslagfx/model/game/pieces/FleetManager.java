package hanze.isy2zeeslagfx.model.game.pieces;

import hanze.isy2zeeslagfx.model.board.BattleshipsBoard;
import hanze.isy2zeeslagfx.model.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FleetManager {
    private final List<Ship> fleet;
    private int nextShipId;

    public FleetManager()
    {
        this.fleet = new ArrayList<>();
        this.nextShipId = 0;
    }

    private int generateNewShipId()
    {
        return nextShipId++;
    }

    public void createShipsForPlayer(int[] newShipsLengths)
    {
        for (int newShipLength : newShipsLengths)
            createNewShip(newShipLength);
    }

    private void createNewShip(int length)
    {
        int shipId = generateNewShipId();
        Ship newShip = new Ship(shipId, length);
        fleet.add(newShip);
    }

    public List<Ship> getFleet()
    {
        return fleet;
    }

    public Ship getShipById(int shipId)
    {
        for (Ship ship : fleet) {
            if (ship.getShipId() == shipId)
                return ship;
        }
        return null;
    }
    public boolean haveAllPlayerShipsBeenPlaced()
    {
        for (Ship ship : fleet) {
            if (!ship.getPlaced()) {
                return false;
            }
        }

        return true;
    }

    public List<Ship> getShipsByLength(int length)
    {
        List<Ship> foundShips = new ArrayList<>();
        for (Ship ship : fleet) {
            if (ship.getLength() == length)
                foundShips.add(ship);
        }

        return foundShips;
    }

    public void printFleet()
    {
        for (Ship ship : fleet) {
            System.out.println(ship.getShipId() + " - " + ship.getLength());
        }
    }
}
