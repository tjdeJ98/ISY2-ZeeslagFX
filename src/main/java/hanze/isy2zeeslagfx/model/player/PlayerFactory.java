package hanze.isy2zeeslagfx.model.player;

public class PlayerFactory {
    public static Player createPlayer(String playerType, String gameType, String playerName) {
        switch (playerType) {
            case "AIPlayer":
                return new AIPlayer(gameType, playerName);
            case "HumanPlayer":
                return new HumanPlayer(gameType, playerName);
            default:
                throw new IllegalArgumentException("Onbekend speltype");
        }
    }
}
