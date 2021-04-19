package by.bsuir.model;

import by.bsuir.Way;

public class AirTransport extends Transport {
    private int count_engine;
    public AirTransport(){}
    public AirTransport(String name, float weight, int max_speed, Way way, int count_engine) {
        super(name, weight, max_speed, way);
        this.count_engine = count_engine;
    }

    public int getCountEngine() {
        return count_engine;
    }

    public void setCountEngine(int count_engine) {
        this.count_engine = count_engine;
    }

}
