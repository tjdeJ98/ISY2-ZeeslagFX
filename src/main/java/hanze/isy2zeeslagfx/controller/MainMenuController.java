package hanze.isy2zeeslagfx.controller;

import hanze.isy2zeeslagfx.config.Config;
import hanze.isy2zeeslagfx.config.Setting;
import hanze.isy2zeeslagfx.model.game.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainMenuController {
    @FXML private Label playerNameLabel;

    @FXML
    public void initialize()
    {
        playerNameLabel.setText(Config.getInstance().getSetting(Setting.NAME));
    }

    @FXML
    public void playBattleShipsLokaal()
    {
        Game game = new Game("Battleships");
        System.out.println(game.getGameBoard().getWidth());
    }
}
