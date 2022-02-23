package by.bsuir.model;

import by.bsuir.Way;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = LandTransport.class, name = "LandTransport"),
        @JsonSubTypes.Type(value = AirTransport.class, name = "AirTransport"),
        @JsonSubTypes.Type(value = PassengerCar.class, name = "PassengerCar"),
        @JsonSubTypes.Type(value = FreightCar.class, name = "FreightCar"),
        @JsonSubTypes.Type(value = Plane.class, name = "Plane"),
        @JsonSubTypes.Type(value = Helicopter.class, name = "Helicopter")
})
abstract public class Transport implements Serializable {
    private String name;
    private float weight;
    private int max_speed;
    private Way way;

    public Transport(){}
    public Transport(String name, float weight, int max_speed, Way way) {
        this.name = name;
        this.weight = weight;
        this.max_speed = max_speed;
        this.way = way;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public int getMaxSpeed() {
        return max_speed;
    }

    public Way getWay() {
        return way;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setMaxSpeed(int max_speed) {
        this.max_speed = max_speed;
    }

    public void setWay(Way way) {
        this.way = way;
    }

    @Override
    public String toString() {
        return name;
    }
}
