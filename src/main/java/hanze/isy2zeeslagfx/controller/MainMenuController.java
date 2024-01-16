package hanze.isy2zeeslagfx.controller;

import hanze.isy2zeeslagfx.config.Config;
import hanze.isy2zeeslagfx.config.Setting;
import hanze.isy2zeeslagfx.model.board.Inputboard;
import hanze.isy2zeeslagfx.model.board.Playboard;
import hanze.isy2zeeslagfx.model.other.Ship;
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
        Playboard playboard = new Playboard();
        playboard.fillBoard(playboard);
        playboard.printBoard();
        System.out.println();
        System.out.println();
        Inputboard inputboard = new Inputboard();
        inputboard.fillBoard(inputboard);
        inputboard.printBoard();
        Ship boot1 = new Ship(1,2);
        System.out.print("Number of Ships created are: " + Ship.getShipsCounter());
    }
}
