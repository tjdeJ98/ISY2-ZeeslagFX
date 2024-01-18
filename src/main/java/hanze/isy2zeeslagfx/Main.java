package hanze.isy2zeeslagfx;

import hanze.isy2zeeslagfx.model.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stageStart) throws IOException {
        ViewManager.initialScene(stageStart);
    }

    public static void main(String[] args) {
        launch();
    }


}