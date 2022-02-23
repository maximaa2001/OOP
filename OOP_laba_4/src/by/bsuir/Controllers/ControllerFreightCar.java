package by.bsuir.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import by.bsuir.Way;
import by.bsuir.model.FreightCar;
import by.bsuir.model.PassengerCar;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerFreightCar {
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
    private TextField max_freight_field;

    private Stage stage;

    public ControllerFreightCar() throws IOException {
        stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/FreightCar.fxml"));
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
            max_freight_field.setStyle("-fx-border-color: silver");
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
            float volume_engine;
            try {
                volume_engine = Float.parseFloat(engine_field.getText());
            }catch (NumberFormatException e){
                engine_field.setStyle("-fx-border-width: 1px");
                engine_field.setStyle("-fx-border-color: red");
                return;
            }
            int max_freight;
            try {
                max_freight = Integer.parseInt(max_freight_field.getText());
            }catch (NumberFormatException e){
                max_freight_field.setStyle("-fx-border-width: 1px");
                max_freight_field.setStyle("-fx-border-color: red");
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
            Controller.transports.add(new FreightCar(name,weight,max_speed,new Way(fromPoint,toPoint),volume_engine,max_freight));
            stage.close();
        });

    }
}
