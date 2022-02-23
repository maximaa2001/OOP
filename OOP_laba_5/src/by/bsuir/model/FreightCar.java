package by.bsuir.model;

import by.bsuir.Way;

public class FreightCar extends LandTransport {
    private int max_freight;
    public FreightCar(){}
    public FreightCar(String name, float weight, int max_speed, Way way, float volume_engine, int max_freight) {
        super(name, weight, max_speed, way, volume_engine);
        this.max_freight = max_freight;
    }

    public int getMaxFreight() {
        return max_freight;
    }

    public void setMaxFreight(int max_freight) {
        this.max_freight = max_freight;
    }

}
