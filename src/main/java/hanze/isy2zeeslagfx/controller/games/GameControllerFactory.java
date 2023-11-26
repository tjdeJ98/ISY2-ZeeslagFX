package hanze.isy2zeeslagfx.controller.games;

import hanze.isy2zeeslagfx.controller.GameController;
import hanze.isy2zeeslagfx.model.game.Battleships;
import hanze.isy2zeeslagfx.model.game.GameModel;

public class GameControllerFactory {

    public enum Game
    {
        Battleships
    }
    public static GameController setupGameController(Game gamePick)
    {
        String name = null; // get username
        GameModel game = switch (gamePick)
        {
            case Battleships -> new Battleships();
        };

        return setupGameController(null);
    }
}
