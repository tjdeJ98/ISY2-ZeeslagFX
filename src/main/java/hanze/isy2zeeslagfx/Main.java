package hanze.isy2zeeslagfx;

import hanze.isy2zeeslagfx.model.view.ViewManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stageStart) throws IOException {
        ViewManager.initialScene(stageStart);
    }

    public static void main(String[] args) {
        launch();
    }


}