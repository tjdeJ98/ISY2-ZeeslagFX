package hanze.isy2zeeslagfx.model.board;

public class BoardFactory {
    public static Board createBoard(String gameType) {
        switch (gameType) {
            case "Battleships":
                return new BattleshipsBoard();
            default:
                throw new IllegalArgumentException("Onbekend speltype");
        }
    }
}
