package by.bsuir.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import by.bsuir.Way;
import by.bsuir.model.AirTransport;
import by.bsuir.model.Plane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerPlane {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name_field;

    @FXML
    private TextField weight_field;

    @FXML
    private TextField speed_field;

    @FXML
    private TextField engine_field;

    @FXML
    private TextField from_field;

    @FXML
    private TextField to_field;

    @FXML
    private Button btn_close;

    @FXML
    private Button btn_create_new;

    @FXML
    private TextField racing_length_field;

    private Stage stage;

    public ControllerPlane() throws IOException {
        stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/Plane.fxml"));
        loader.setController(this);
        stage.setScene(new Scene(loader.load()));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    void initialize() {
        btn_close.setOnMouseClicked(event -> {
            stage.close();
        });

        btn_create_new.setOnMouseClicked(event -> {
            name_field.setStyle("-fx-border-color: silver");
            weight_field.setStyle("-fx-border-color: silver");
            speed_field.setStyle("-fx-border-color: silver");
            engine_field.setStyle("-fx-border-color: silver");
            from_field.setStyle("-fx-border-color: silver");
            to_field.setStyle("-fx-border-color: silver");
            racing_length_field.setStyle("-fx-border-color: silver");
            String name;
            if(!name_field.getText().equals("")) {
                name =  name_field.getText();
            }
            else {
                name_field.setStyle("-fx-border-width: 1px");
                name_field.setStyle("-fx-border-color: red");
                return;
            }
            float weight;
            try {
                weight = Float.parseFloat(weight_field.getText());
            }catch (NumberFormatException e){
                weight_field.setStyle("-fx-border-width: 1px");
                weight_field.setStyle("-fx-border-color: red");
                return;
            }
            int max_speed;
            try{
                max_speed = Integer.parseInt(speed_field.getText());
            }catch (NumberFormatException e){
                speed_field.setStyle("-fx-border-width: 1px");
                speed_field.setStyle("-fx-border-color: red");
                return;
            }
            int count_engine;
            try {
                count_engine = Integer.parseInt(engine_field.getText());
            }catch (NumberFormatException e){
                engine_field.setStyle("-fx-border-width: 1px");
                engine_field.setStyle("-fx-border-color: red");
                return;
            }
            int racing_length;
            try {
                racing_length = Integer.parseInt(racing_length_field.getText());
            }catch (NumberFormatException e){
                racing_length_field.setStyle("-fx-border-width: 1px");
                racing_length_field.setStyle("-fx-border-color: red");
                return;
            }
            String fromPoint;
            if(!from_field.getText().equals("")) {
                fromPoint = from_field.getText();
            }
            else {
                from_field.setStyle("-fx-border-width: 1px");
                from_field.setStyle("-fx-border-color: red");
                return;
            }
            String toPoint;
            if(!to_field.getText().equals("")) {
                toPoint = to_field.getText();
            }
            else {
                to_field.setStyle("-fx-border-width: 1px");
                to_field.setStyle("-fx-border-color: red");
                return;
            }
            Controller.transports.add(new Plane(name,weight,max_speed,new Way(fromPoint,toPoint),count_engine,racing_length));
            stage.close();
        });


    }
}
