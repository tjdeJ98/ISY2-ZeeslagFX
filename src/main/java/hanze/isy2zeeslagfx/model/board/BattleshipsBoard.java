package hanze.isy2zeeslagfx.model.board;

public class BattleshipsBoard implements Board {
    private final int width = 8;
    private final int height = 8;

    public BattleshipsBoard() {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
