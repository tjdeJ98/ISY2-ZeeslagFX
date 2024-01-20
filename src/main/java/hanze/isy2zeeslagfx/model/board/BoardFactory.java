package hanze.isy2zeeslagfx.model.board;

import hanze.isy2zeeslagfx.model.player.AIPlayer;
import hanze.isy2zeeslagfx.model.player.HumanPlayer;

public class BoardFactory {
    public static Board createBoard(String gameType) {
        return switch (gameType) {
            case "Battleships" -> new BattleshipsBoard();
            default -> throw new IllegalArgumentException("Onbekend speltype");
        };
    }
}
