package hanze.isy2zeeslagfx.model.game.pieces;

public class Ship {
    private final int length;
    private final int Id;
    private boolean state; // true = placed && not sunk, false = not placed || sunk
    private boolean placed; // true = placed on board, false = not placed on board

    public Ship(int shipId, int length)
    {
        this.length = length;
        this.Id = shipId;
        this.state = false;
        this.placed = false;
    }

    public int getLength()
    {
        return this.length;
    }

    public int getShipId()
    {
        return this.Id;
    }

    public boolean getState()
    {
        return this.state;
    }

    public void setState()
    {
        this.state = !this.state;
    }

    public boolean getPlaced()
    {
        return this.placed;
    }

    public void setPlaced()
    {
        this.placed = !this.placed;
    }
}
