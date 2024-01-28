package hanze.isy2zeeslagfx;

import hanze.isy2zeeslagfx.network.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import hanze.isy2zeeslagfx.network.ResponseListener.*;

public class Main extends Application {
    public static Scene scene;
    public static Stage stage;


    @Override
    public void start(Stage stageStart) throws IOException {
        stage = stageStart;
        URL fxmlLocation = getClass().getResource("fxml/hello-view.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
//        launch();
//        Receiver receiver = new Receiver();
//        CommandShutdown commandShutdown = new CommandShutdown(receiver);
//        commandShutdown.execute();



        //launch();
    }

    public static void setScene(String fxmlName)
    {
        try {
            stage.getScene().setRoot(loadSceneFile(fxmlName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Parent loadSceneFile(String fxmlName) throws IOException
    {
        URL fxmlLocation = Main.class.getResource("fxml/" + fxmlName + ".fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        return fxmlLoader.load();
    }

    public static void changeScene(String fxmlName) throws IOException
    {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("fxml/" + fxmlName + ".fxml")));
        stage.getScene().setRoot(pane);
    }
}