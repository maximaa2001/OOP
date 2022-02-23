package by.bsuir.model;

import by.bsuir.Way;

public class LandTransport extends Transport{
    private float volume_engine;
    public LandTransport(){}
    public LandTransport(String name,float weight, int max_speed, Way way, float volume_engine) {
        super(name,weight, max_speed, way);
        this.volume_engine = volume_engine;
    }

    public float getVolumeEngine() {
        return volume_engine;
    }

    public void setVolumeEngine(float volume_engine) {
        this.volume_engine = volume_engine;
    }
}
