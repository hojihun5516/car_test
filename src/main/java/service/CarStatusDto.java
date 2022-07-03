package service;

import domain.Car;
import domain.Gear;

public class CarStatusDto {

    private final String name;
    private final String number;
    private final int speed;
    private final Gear gear;

    public CarStatusDto(Car car) {
        this.name = car.getName();
        this.number = car.getNumber();
        this.speed = car.getSpeed();
        this.gear = car.getGear();
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getSpeed() {
        return speed;
    }

    public Gear getGear() {
        return gear;
    }
}
