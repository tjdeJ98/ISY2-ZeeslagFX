package hanze.isy2zeeslagfx.model.board;

public interface Board {

    void initializeBoard();

    void printBoard();

    void shipPlacement(String startCoordinate, String endCoordinate, int shipId);
}
