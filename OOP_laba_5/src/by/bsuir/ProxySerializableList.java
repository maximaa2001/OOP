package by.bsuir;

import by.bsuir.interfaces.SerList;
import by.bsuir.model.Transport;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class ProxySerializableList implements SerList {
    private SerList serializableList = new SerializableList();

    public ProxySerializableList(){}

    public ProxySerializableList(ObservableList<Transport> observableList){
        ArrayList<Transport> arrayList = new ArrayList<>(observableList);
        this.setArrayList(arrayList);
    }

    @Override
    public ArrayList<Transport> getArrayList() {
        return serializableList.getArrayList();
    }

    @Override
    public void setArrayList(ArrayList<Transport> arrayList) {
        if(!arrayList.isEmpty()){
            serializableList.setArrayList(arrayList);
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Список пуст");
            alert.showAndWait();
        }
    }
}
