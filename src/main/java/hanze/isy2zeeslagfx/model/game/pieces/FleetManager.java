package hanze.isy2zeeslagfx.model.game.pieces;

import java.util.ArrayList;
import java.util.List;

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

    public void createNewShip(int length)
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

    public List<Ship> getShipsByLength(int length)
    {
        List<Ship> foundShips = new ArrayList<>();
        for (Ship ship : fleet) {
            if (ship.getLength() == length)
                foundShips.add(ship);
        }

        return foundShips;
    }
}
