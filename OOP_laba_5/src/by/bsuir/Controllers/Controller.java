package by.bsuir.Controllers;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import by.bsuir.ProxySerializableList;
import by.bsuir.SerializableList;
import by.bsuir.interfaces.SerList;
import by.bsuir.interfaces.UserArchivator;
import by.bsuir.interfaces.UserXTJ;
import by.bsuir.model.*;
import by.bsuir.plugins.AdapterArchivator;
import by.bsuir.plugins.AdapterXTJ;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<Class> choose_class;

    @FXML
    private Button btn_create;

    @FXML
    private TableView<Transport> table;

    @FXML
    private Button btn_remove;

    @FXML
    private Button btn_edit;

    @FXML
    private TableColumn<Transport, String> column_name;

    @FXML
    private TableColumn<Transport, Class> column_class;

    @FXML
    private Button btn_update;

    @FXML
    private ChoiceBox<String> choose_serialization;

    @FXML
    private Button btn_serial;

    @FXML
    private Button btn_deserial;

    @FXML
    private TableView<File> table_plugins;

    @FXML
    private TableColumn<File, String> name_plugin;

    @FXML
    private Button btn_xml_to_json;


    @FXML
    private Button btn_archivator;

    private ObservableList<Class> classes = FXCollections.observableArrayList(LandTransport.class, AirTransport.class,
            PassengerCar.class, FreightCar.class, Plane.class,Helicopter.class);

    private ObservableList<String> serializations = FXCollections.observableArrayList("Binary","XML","Json");


    public static ObservableList<Transport> transports = FXCollections.observableArrayList();

    private ObservableList<File> plugins = FXCollections.observableArrayList();


    @FXML
    void initialize() {
        choose_class.setItems(classes);
        choose_class.setValue(LandTransport.class);

        choose_serialization.setItems(serializations);
        choose_serialization.setValue("Binary");

        column_name.setCellValueFactory(new PropertyValueFactory<Transport,String>("name"));
        column_class.setCellValueFactory(transports -> new SimpleObjectProperty(transports.getValue().getClass().getSimpleName()));
        table.setItems(transports);

        File file = new File("src/by/bsuir/plugins");
        File[] files = file.listFiles();
        plugins.addAll(Arrays.asList(files));
        table_plugins.setItems(plugins);
        name_plugin.setCellValueFactory(plugins -> new SimpleObjectProperty(plugins.getValue().getName()));
        btn_xml_to_json.setOnMouseClicked(event -> {
            MultipleSelectionModel<File> model = table_plugins.getSelectionModel();
            File plugin = model.getSelectedItem();
            if(plugin != null) {
                String plugin_name = plugin.getName().split("\\.")[0];
                try {
                    if(plugin_name.equals("AdapterXTJ")){
                        UserXTJ userXTJ = AdapterXTJ.getInstance();
                        FileChooser fileChooser = new FileChooser();
                        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("xml","*.xml"));
                        File file1 = fileChooser.showOpenDialog(null);
                        if(file1 != null){
                            userXTJ.transformXmlToJson(file1);
                        }
                    }
                } catch ( IOException | ClassCastException e) {
                    e.printStackTrace();
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Выберите другой плагин");
                    alert.showAndWait();
                }
            }
        });

        btn_archivator.setOnMouseClicked(event -> {
            MultipleSelectionModel<File> model = table_plugins.getSelectionModel();
            File plugin = model.getSelectedItem();
            String plugin_name = plugin.getName().split("\\.")[0];
            try {
                if(plugin_name.equals("AdapterArchivator")){
                    UserArchivator userArchivator = AdapterArchivator.getInstance();
                    DirectoryChooser directoryChooser = new DirectoryChooser();
                    File file1 = directoryChooser.showDialog(null);
                    if(file1 != null){
                        userArchivator.createZip(file1);
                    }
                }
            } catch (IOException | ClassCastException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Выберите другой плагин");
                alert.showAndWait();
            }
        });
        btn_create.setOnMouseClicked(event -> {
            if(choose_class.getValue().equals(LandTransport.class)){
                try {
                    ControllerLandTransport controllerLandTransport = new ControllerLandTransport();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(choose_class.getValue().equals(AirTransport.class)){
                try {
                    ControllerAirTransport controllerAirTransport = new ControllerAirTransport();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(choose_class.getValue().equals(PassengerCar.class)){
                try {
                    ControllerPassengerCar controllerPassengerCar = new ControllerPassengerCar();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(choose_class.getValue().equals(FreightCar.class)){
                try {
                    ControllerFreightCar controllerFreightCar = new ControllerFreightCar();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(choose_class.getValue().equals(Plane.class)){
                try {
                    ControllerPlane controllerPlane = new ControllerPlane();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(choose_class.getValue().equals(Helicopter.class)){
                try {
                    ControllerHelicopter controllerHelicopter = new ControllerHelicopter();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_remove.setOnMouseClicked(event -> {
            MultipleSelectionModel<Transport> model = table.getSelectionModel();
            transports.remove(model.getSelectedItem());
            model.clearSelection();
        });

        btn_edit.setOnMouseClicked(event -> {
            MultipleSelectionModel<Transport> model = table.getSelectionModel();
            if(!(model.getSelectedItem() == null)) {
                if (model.getSelectedItem().getClass().equals(LandTransport.class)) {
                    try {
                        ControllerEditLandTransport controllerEditLandTransport = new ControllerEditLandTransport((LandTransport) model.getSelectedItem());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else if(model.getSelectedItem().getClass().equals(AirTransport.class)){
                    try {
                        ControllerEditAirTransport controllerEditAirTransport = new ControllerEditAirTransport((AirTransport) model.getSelectedItem());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else if(model.getSelectedItem().getClass().equals(PassengerCar.class)){
                    try {
                        ControllerEditPassengerCar controllerEditPassengerCar = new ControllerEditPassengerCar((PassengerCar) model.getSelectedItem());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else if(model.getSelectedItem().getClass().equals(FreightCar.class)){
                    try {
                        ControllerEditFreightCar controllerEditFreightCar = new ControllerEditFreightCar((FreightCar) model.getSelectedItem());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else if(model.getSelectedItem().getClass().equals(Plane.class)){
                    try {
                        ControllerEditPlane controllerEditPlane = new ControllerEditPlane((Plane) model.getSelectedItem());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else if(model.getSelectedItem().getClass().equals(Helicopter.class)){
                    try {
                       ControllerEditHelicopter controllerEditHelicopter = new ControllerEditHelicopter((Helicopter) model.getSelectedItem());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                model.clearSelection();
            }
        });

        btn_update.setOnMouseClicked(event -> {
            table.refresh();
        });

        btn_serial.setOnMouseClicked(event -> {
            if(choose_serialization.getValue().equals("Binary")){
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    List<Transport> list = new ArrayList<>(transports);
                    objectOutputStream.writeObject(list);
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(choose_serialization.getValue().equals("XML")){
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream("file.xml");
                    XMLEncoder xmlEncoder = new XMLEncoder(fileOutputStream);
                    List<Transport> list = new ArrayList<>(transports);
                    xmlEncoder.writeObject(list);
                    xmlEncoder.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }else if(choose_serialization.getValue().equals("Json")){
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    SerList serializableList = new ProxySerializableList(transports);
                    if(serializableList.getArrayList().size() != 0) {
                        FileOutputStream outputStream = new FileOutputStream("file.json");
                        objectMapper.writeValue(outputStream, serializableList);
                        outputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btn_deserial.setOnMouseClicked(event -> {
            if(choose_serialization.getValue().equals("Binary")){
                try {
                    FileInputStream fileInputStream = new FileInputStream("file.txt");
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    List list = (List) objectInputStream.readObject();
                    for (int i = 0; i < list.size() ; i++) {
                        transports.add((Transport) list.get(i));
                    }
                    objectInputStream.close();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }else if(choose_serialization.getValue().equals("XML")){
                try {
                    FileInputStream fileInputStream = new FileInputStream("file.xml");
                    XMLDecoder xmlDecoder = new XMLDecoder(fileInputStream);
                    List list = (List) xmlDecoder.readObject();
                    for (int i = 0; i < list.size(); i++) {
                        transports.add((Transport) list.get(i));
                    }
                    xmlDecoder.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }else if(choose_serialization.getValue().equals("Json")){
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    FileInputStream inputStream = new FileInputStream("file.json");
                    ObservableList<Transport> list = FXCollections.observableList(((SerializableList) objectMapper.readValue(inputStream, SerializableList.class)).getArrayList());
                    transports.addAll(list);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


