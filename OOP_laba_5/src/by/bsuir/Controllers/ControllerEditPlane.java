package by.bsuir.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import by.bsuir.model.AirTransport;
import by.bsuir.model.Plane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ControllerEditPlane {

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
    private TextField racing_length_field;

    @FXML
    private Button btn_edit;

    private Stage stage;
    private Plane plane;

    public ControllerEditPlane(Plane plane) throws IOException {
        this.plane = plane;
        stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/EditPlane.fxml"));
        loader.setController(this);
        stage.setScene(new Scene(loader.load()));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    void initialize() {
        name_field.setText(plane.getName());
        weight_field.setText(String.valueOf(plane.getWeight()));
        speed_field.setText(String.valueOf(plane.getMaxSpeed()));
        engine_field.setText(String.valueOf(plane.getCountEngine()));
        racing_length_field.setText(String.valueOf(plane.getRacingLength()));
        from_field.setText(plane.getWay().getFromPoint());
        to_field.setText(plane.getWay().getToPoint());

        btn_edit.setOnMouseClicked(event -> {
            name_field.setStyle("-fx-border-color: silver");
            weight_field.setStyle("-fx-border-color: silver");
            speed_field.setStyle("-fx-border-color: silver");
            engine_field.setStyle("-fx-border-color: silver");
            racing_length_field.setStyle("-fx-border-color: silver");
            from_field.setStyle("-fx-border-color: silver");
            to_field.setStyle("-fx-border-color: silver");
            if(!name_field.getText().equals("")) {
                plane.setName(name_field.getText());
            }
            else {
                name_field.setStyle("-fx-border-width: 1px");
                name_field.setStyle("-fx-border-color: red");
                return;
            }
            float weight;
            try {
                weight = Float.parseFloat(weight_field.getText());
                plane.setWeight(weight);
            }catch (NumberFormatException e){
                weight_field.setStyle("-fx-border-width: 1px");
                weight_field.setStyle("-fx-border-color: red");
                return;
            }
            int max_speed;
            try{
                max_speed = Integer.parseInt(speed_field.getText());
                plane.setMaxSpeed(max_speed);
            }catch (NumberFormatException e){
                speed_field.setStyle("-fx-border-width: 1px");
                speed_field.setStyle("-fx-border-color: red");
                return;
            }
            int count_engine;
            try {
                count_engine = Integer.parseInt(engine_field.getText());
                plane.setCountEngine(count_engine);
            }catch (NumberFormatException e){
                engine_field.setStyle("-fx-border-width: 1px");
                engine_field.setStyle("-fx-border-color: red");
                return;
            }
            int racing_length;
            try {
                racing_length = Integer.parseInt(racing_length_field.getText());
                plane.setRacingLength(racing_length);
            }catch (NumberFormatException e){
                racing_length_field.setStyle("-fx-border-width: 1px");
                racing_length_field.setStyle("-fx-border-color: red");
                return;
            }
            if(!from_field.getText().equals("")) {
                plane.getWay().setFromPoint(from_field.getText());
            }
            else {
                from_field.setStyle("-fx-border-width: 1px");
                from_field.setStyle("-fx-border-color: red");
                return;
            }
            if(!to_field.getText().equals("")) {
                plane.getWay().setToPoint(to_field.getText());
            }
            else {
                to_field.setStyle("-fx-border-width: 1px");
                to_field.setStyle("-fx-border-color: red");
                return;
            }
            stage.close();
        });


    }
}
