package by.bsuir.model;

import by.bsuir.Way;

public class Plane extends AirTransport {
    private int racing_length;
    public Plane(){}
    public Plane(String name,float weight, int max_speed, Way way, int count_engine, int racing_length) {
        super(name, weight, max_speed, way, count_engine);
        this.racing_length = racing_length;
    }

    public int getRacingLength() {
        return racing_length;
    }

    public void setRacingLength(int racing_length) {
        this.racing_length = racing_length;
    }
}
