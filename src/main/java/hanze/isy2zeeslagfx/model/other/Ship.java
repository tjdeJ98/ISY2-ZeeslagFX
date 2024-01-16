package hanze.isy2zeeslagfx.model.other;

public class Ship {
    private int shipCount;
    int startCoordinate;
    int endCoordinate;

    public Ship(int startCoordinate, int endCoordinate) {
        this.startCoordinate = startCoordinate;
        this.endCoordinate = endCoordinate;
        ++this.shipCount;
    }

    public int getShipCount() {
        return this.shipCount;
    }

    public void setShipCount(int shipCount) {
        this.shipCount = shipCount;
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
