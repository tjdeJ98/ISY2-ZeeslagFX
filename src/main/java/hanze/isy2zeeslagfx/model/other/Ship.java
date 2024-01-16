package hanze.isy2zeeslagfx.model.other;

public class Ship {
    private static int shipCounter;
    int startCoordinate;
    int endCoordinate;

    public Ship(int startCoordinate, int endCoordinate) {
        this.startCoordinate = startCoordinate;
        this.endCoordinate = endCoordinate;
        shipCounter++;
    }

    public static int getShipsCounter() {
        return shipCounter;
    }

    public static void setShipsCounter(int shipCount) {
        Ship.shipCounter = shipCount;
    }

    public int getStartCoordinate() {
        return this.startCoordinate;
    }

    public void setStartCoordinate(int startCoordinate) {
        this.startCoordinate = startCoordinate;
    }

    public int getEndCoordinate() {
        return this.endCoordinate;
    }

    public void setEndCoordinate(int endCoordinate) {
        this.endCoordinate = endCoordinate;
    }
}
