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
        Inputboard inputboard = new Inputboard();
        inputboard.fillBoard(inputboard, new Ship(2,3));
        inputboard.printBoard();
        Ship boot1 = new Ship(1,2);
        Ship boot2 = new Ship(2,3);
        Ship boot3 = new Ship(3,4);
        Ship boot4 = new Ship(4,5);
        System.out.println();
        playboard.printBoard();
        System.out.println();
    }
}
