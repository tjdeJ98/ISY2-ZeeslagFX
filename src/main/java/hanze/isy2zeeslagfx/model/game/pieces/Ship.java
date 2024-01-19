package hanze.isy2zeeslagfx.model.game.pieces;

public class Ship {
    private int length;
    private int shipId;

    public Ship(int length, int shipId)
    {
        this.length = length;
        this.shipId = shipId;
    }

    public int getLength()
    {
        return length;
    }

    public int getShipId()
    {
        return shipId;
    }
}
