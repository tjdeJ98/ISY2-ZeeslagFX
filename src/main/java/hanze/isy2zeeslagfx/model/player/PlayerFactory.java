package hanze.isy2zeeslagfx.model.player;

public class PlayerFactory {
    public static Player createPlayer(String name) {
        switch (name) {
            case "AIPlayer":
                return new AIPlayer(name);
            case "HumanPlayer":
                return new HumanPlayer(name);
            default:
                throw new IllegalArgumentException("Onbekend speltype");
        }
    }
}
