package by.bsuir.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import by.bsuir.model.LandTransport;
import by.bsuir.model.PassengerCar;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerEditPassengerCar {

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
    private TextField count_passenger_field;

    @FXML
    private Button btn_edit;

    private Stage stage;
    private PassengerCar passengerCar;

    public ControllerEditPassengerCar(PassengerCar passengerCar) throws IOException {
        this.passengerCar = passengerCar;
        stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/EditPassengerCar.fxml"));
        loader.setController(this);
        stage.setScene(new Scene(loader.load()));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    void initialize() {
        name_field.setText(passengerCar.getName());
        weight_field.setText(String.valueOf(passengerCar.getWeight()));
        speed_field.setText(String.valueOf(passengerCar.getMaxSpeed()));
        engine_field.setText(String.valueOf(passengerCar.getVolumeEngine()));
        count_passenger_field.setText(String.valueOf(passengerCar.getCountPassenger()));
        from_field.setText(passengerCar.getWay().getFromPoint());
        to_field.setText(passengerCar.getWay().getToPoint());

        btn_edit.setOnMouseClicked(event -> {
            name_field.setStyle("-fx-border-color: silver");
            weight_field.setStyle("-fx-border-color: silver");
            speed_field.setStyle("-fx-border-color: silver");
            engine_field.setStyle("-fx-border-color: silver");
            count_passenger_field.setStyle("-fx-border-color: silver");
            from_field.setStyle("-fx-border-color: silver");
            to_field.setStyle("-fx-border-color: silver");
            if(!name_field.getText().equals("")) {
                passengerCar.setName(name_field.getText());
            }
            else {
                name_field.setStyle("-fx-border-width: 1px");
                name_field.setStyle("-fx-border-color: red");
                return;
            }
            float weight;
            try {
                weight = Float.parseFloat(weight_field.getText());
                passengerCar.setWeight(weight);
            }catch (NumberFormatException e){
                weight_field.setStyle("-fx-border-width: 1px");
                weight_field.setStyle("-fx-border-color: red");
                return;
            }
            int max_speed;
            try{
                max_speed = Integer.parseInt(speed_field.getText());
                passengerCar.setMaxSpeed(max_speed);
            }catch (NumberFormatException e){
                speed_field.setStyle("-fx-border-width: 1px");
                speed_field.setStyle("-fx-border-color: red");
                return;
            }
            float volume_engine;
            try {
                volume_engine = Float.parseFloat(engine_field.getText());
                passengerCar.setVolumeEngine(volume_engine);
            }catch (NumberFormatException e){
                engine_field.setStyle("-fx-border-width: 1px");
                engine_field.setStyle("-fx-border-color: red");
                return;
            }
            int count_passenger;
            try {
                count_passenger = Integer.parseInt(count_passenger_field.getText());
                passengerCar.setCountPassenger(count_passenger);
            }catch (NumberFormatException e){
                count_passenger_field.setStyle("-fx-border-width: 1px");
                count_passenger_field.setStyle("-fx-border-color: red");
                return;
            }
            if(!from_field.getText().equals("")) {
                passengerCar.getWay().setFromPoint(from_field.getText());
            }
            else {
                from_field.setStyle("-fx-border-width: 1px");
                from_field.setStyle("-fx-border-color: red");
                return;
            }
            if(!to_field.getText().equals("")) {
                passengerCar.getWay().setToPoint(to_field.getText());
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
