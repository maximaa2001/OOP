package by.bsuir;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
    public static Stage mainStage;
    public static Scene mainScene;


    public static void main(String[] args)  {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        Parent parent = FXMLLoader.load(getClass().getResource("MainStage.fxml"));
        mainScene = new Scene(parent,1000,800);
        mainStage.setScene(mainScene);
        mainStage.setTitle("Графический редактор");
        mainStage.show();
    }
}
