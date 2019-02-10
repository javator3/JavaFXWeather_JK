package pl.sda.openweather.model;

public class Weather {

    private Current current;
    private Location location;

    public Weather(){}
    public Weather(Current current, Location location) {
        this.current = current;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "current=" + current +
                ", location=" + location +
                '}';
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
