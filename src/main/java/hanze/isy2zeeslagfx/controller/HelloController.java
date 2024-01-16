package hanze.isy2zeeslagfx.controller;

import hanze.isy2zeeslagfx.Main;
import hanze.isy2zeeslagfx.config.Config;
import hanze.isy2zeeslagfx.config.Setting;
import  javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class HelloController {

    @FXML private Label label;
    @FXML private TextField helloViewNameBox;
    @FXML private CheckBox rememberMeCheckBox;

    @FXML
    public void initialize()
    {
        label.setText("");
        helloViewNameBox.setText(Config.getInstance().getSetting(Setting.NAME));
        boolean textBoxEmpty = helloViewNameBox.getText().isEmpty();
        rememberMeCheckBox.setSelected(!textBoxEmpty);
    }

    @FXML
    private void handleStartButtonAction(ActionEvent event) {
        String name = helloViewNameBox.getText();
        if (name.isEmpty()) {
            label.setText("A username is required");
            return;
        }

        if (rememberMeCheckBox.isSelected()) {
            Config.getInstance().setSetting(Setting.NAME, name);
        }

        Main.setScene("mainMenu");
    }


}
