package hanze.isy2zeeslagfx.model.player;

public class PlayerFactory {
    public static Player createPlayer(String playerType, String gameType, String playerName) {
        return switch (playerType) {
            case "AIPlayer" -> new AIPlayer(gameType, playerName);
            case "HumanPlayer" -> new HumanPlayer(gameType, playerName);
            default -> throw new IllegalArgumentException("Onbekend speltype");
        };
    }
}
