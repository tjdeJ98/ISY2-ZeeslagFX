package hanze.isy2zeeslagfx.model.board;

import hanze.isy2zeeslagfx.model.game.pieces.Ship;

public class BattleshipCell {
    private int shipId;
    private final String coordinate;
    private boolean hit;

    public BattleshipCell(String coordinate)
    {
        this.coordinate = coordinate;
        this.shipId = -1;
        this.hit = false;
    }

    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId)
    {
        this.shipId = shipId;
    }

    public String getCoordinate()
    {
        return this.coordinate;
    }

    public void setHit()
    {
        this.hit = true;
    }

    public boolean getHit()
    {
        return this.hit;
    }
}
