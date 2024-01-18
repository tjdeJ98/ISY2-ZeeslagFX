package hanze.isy2zeeslagfx.model.view;

import hanze.isy2zeeslagfx.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ViewManager {
    public static Scene scene;
    public static Stage stage;
    private static final String path = "/hanze/isy2zeeslagfx/fxml/";

    public static void initialScene(Stage stageStart) throws IOException {
        stage = stageStart;
        URL fxmlLocation = ViewManager.class.getResource(path + "hello-view.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
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
        URL fxmlLocation = Main.class.getResource(path + fxmlName + ".fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        return fxmlLoader.load();
    }
}
