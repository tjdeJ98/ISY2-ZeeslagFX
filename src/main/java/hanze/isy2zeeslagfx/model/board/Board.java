package hanze.isy2zeeslagfx.model.board;

public interface Board {

    void initializeBoard();
    void printBoard();
    void printOnlyHitsBoard();
    boolean checkIfCellAlreadyPicked(String input);
    int select(String coordinate);
}
