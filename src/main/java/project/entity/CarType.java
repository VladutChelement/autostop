package project.entity;

public enum CarType {
    SUV("SUV"),
    Hatchback("Hatchback"),
    Crossover("Crossover"),
    Convertible("Convertible"),
    SportsCar("Sports Car"),
    Coupe("Coupe"),
    Minivan("Minivan"),
    StationWagon("Station Wagon"),
    PickupTruck("Pickup Truck");

    private final String displayEnum;

    CarType(String displayEnum) {

        this.displayEnum = displayEnum;
    }

    public String getDisplayEnum() {

        return displayEnum;
    }
}