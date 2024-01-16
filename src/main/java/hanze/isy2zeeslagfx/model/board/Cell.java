package hanze.isy2zeeslagfx.model.board;

public class Cell {
    private enum CellStatus {
        EMPTY("EM"),
        SHIP("SH"),
        HIT("HI"),
        MISS("MI"),
        SUNK("SU");

        String cellCharacter;

        CellStatus(String cellCharacter) {
            this.cellCharacter = cellCharacter;
        }
    }

    private boolean isShip, isHit, isHidden, isSunk;
    private final int x,y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.isShip = false;
        this.isHit = false;
        this.isHidden = false;
        this.isSunk = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setShip() {
        this.isShip = true;
    }

    public void setHit() {
        this.isHit = true;
    }

    public void setSunk() {
        this.isSunk = true;
    }

    public void setVisibility(boolean state) {
        this.isHidden = state;
    }

    public boolean isShip() {
        return isShip;
    }

    public boolean isHit() {
        return isHit;
    }

    public boolean isSunk() {
        return isSunk;
    }

    public boolean isHidden() {
        return isHidden;
    }

}
