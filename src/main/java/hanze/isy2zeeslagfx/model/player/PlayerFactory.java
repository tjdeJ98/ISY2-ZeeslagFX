package hanze.isy2zeeslagfx.model.player;

public class PlayerFactory {
    public static Player createPlayer(String name, String gameType) {
        switch (name) {
            case "AIPlayer":
                return new AIPlayer(name, gameType);
            case "HumanPlayer":
                return new HumanPlayer(name, gameType);
            default:
                throw new IllegalArgumentException("Onbekend speltype");
        }
    }
}
