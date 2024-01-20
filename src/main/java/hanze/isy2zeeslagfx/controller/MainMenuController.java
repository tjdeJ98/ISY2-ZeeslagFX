package hanze.isy2zeeslagfx.controller;

import hanze.isy2zeeslagfx.config.Config;
import hanze.isy2zeeslagfx.config.Setting;
import hanze.isy2zeeslagfx.model.game.BattleshipGame;
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
        BattleshipGame battleshipGame = new BattleshipGame("Battleships", Game.PlayersSetupType.PLAYER_VS_PLAYER);
        System.out.println("Game setup and started");
    }
}
