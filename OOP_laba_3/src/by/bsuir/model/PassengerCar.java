package by.bsuir.model;

import by.bsuir.Way;

public class PassengerCar extends LandTransport{
    private int countPassenger;
    public PassengerCar(){}
    public PassengerCar(String name, float weight, int max_speed, Way way, float volume_engine, int countPassenger) {
        super(name, weight, max_speed, way, volume_engine);
        this.countPassenger = countPassenger;
    }

    public int getCountPassenger() {
        return countPassenger;
    }

    public void setCountPassenger(int countPassenger) {
        this.countPassenger = countPassenger;
    }

}
