package by.bsuir.model;

import by.bsuir.Way;

public class Helicopter extends AirTransport{
    private int rotational_speed;
    public Helicopter(){}
    public Helicopter(String name,float weight, int max_speed, Way way, int count_engine, int rotational_speed) {
        super(name, weight, max_speed, way, count_engine);
        this.rotational_speed = rotational_speed;
    }

    public int getRotationalSpeed() {
        return rotational_speed;
    }

    public void setRotationalSpeed(int rotational_speed) {
        this.rotational_speed = rotational_speed;
    }
}
