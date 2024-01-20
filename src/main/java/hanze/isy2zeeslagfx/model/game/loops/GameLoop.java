package hanze.isy2zeeslagfx.model.game.loops;

import hanze.isy2zeeslagfx.controller.GameController;
import hanze.isy2zeeslagfx.model.game.Game;

import java.util.Random;

public class GameLoop implements Runnable {
    private final Game game;
    private boolean status;

    public GameLoop(Game game)
    {
        this.game = game;
    }

    public void run()
    {
        status = true;
        while (status) {
            game.update();
            game.checkForEnd();
        }
    }

    public void stop()
    {
        status = false;
    }

    public boolean isGameRunning()
    {
        return status;
    }

    protected void render()
    {

    }
}
