package by.bsuir;

import by.bsuir.model.Transport;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import javafx.collections.ObservableList;

import java.util.ArrayList;

@JsonAutoDetect
public class SerializableList {

    public ArrayList<Transport> arrayList;

    public SerializableList(){}

    public SerializableList(ArrayList<Transport> arrayList){
        this.arrayList = arrayList;
    }

    public SerializableList(ObservableList<Transport> observableList){
        ArrayList<Transport> arrayList = new ArrayList<>(observableList);
        this.arrayList = arrayList;
    }

    public ArrayList<Transport> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Transport> arrayList) {
        this.arrayList = arrayList;
    }
}
