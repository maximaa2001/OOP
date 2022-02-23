package by.bsuir.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import by.bsuir.Way;
import by.bsuir.model.LandTransport;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerEditLandTransport {

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
    private Button btn_edit;

    private Stage stage;
    private LandTransport landTransport;

    public ControllerEditLandTransport(LandTransport landTransport) throws IOException {
        this.landTransport = landTransport;
        stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/EditLandTransport.fxml"));
        loader.setController(this);
        stage.setScene(new Scene(loader.load()));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    void initialize() {
        name_field.setText(landTransport.getName());
        weight_field.setText(String.valueOf(landTransport.getWeight()));
        speed_field.setText(String.valueOf(landTransport.getMaxSpeed()));
        engine_field.setText(String.valueOf(landTransport.getVolumeEngine()));
        from_field.setText(landTransport.getWay().getFromPoint());
        to_field.setText(landTransport.getWay().getToPoint());

        btn_edit.setOnMouseClicked(event -> {
            name_field.setStyle("-fx-border-color: silver");
            weight_field.setStyle("-fx-border-color: silver");
            speed_field.setStyle("-fx-border-color: silver");
            engine_field.setStyle("-fx-border-color: silver");
            from_field.setStyle("-fx-border-color: silver");
            to_field.setStyle("-fx-border-color: silver");
            if(!name_field.getText().equals("")) {
                landTransport.setName(name_field.getText());
            }
            else {
                name_field.setStyle("-fx-border-width: 1px");
                name_field.setStyle("-fx-border-color: red");
                return;
            }
            float weight;
            try {
                weight = Float.parseFloat(weight_field.getText());
                landTransport.setWeight(weight);
            }catch (NumberFormatException e){
                weight_field.setStyle("-fx-border-width: 1px");
                weight_field.setStyle("-fx-border-color: red");
                return;
            }
            int max_speed;
            try{
                max_speed = Integer.parseInt(speed_field.getText());
                landTransport.setMaxSpeed(max_speed);
            }catch (NumberFormatException e){
                speed_field.setStyle("-fx-border-width: 1px");
                speed_field.setStyle("-fx-border-color: red");
                return;
            }
            float volume_engine;
            try {
                volume_engine = Float.parseFloat(engine_field.getText());
                landTransport.setVolumeEngine(volume_engine);
            }catch (NumberFormatException e){
                engine_field.setStyle("-fx-border-width: 1px");
                engine_field.setStyle("-fx-border-color: red");
                return;
            }
            if(!from_field.getText().equals("")) {
                landTransport.getWay().setFromPoint(from_field.getText());
            }
            else {
                from_field.setStyle("-fx-border-width: 1px");
                from_field.setStyle("-fx-border-color: red");
                return;
            }
            if(!to_field.getText().equals("")) {
                landTransport.getWay().setToPoint(to_field.getText());
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
