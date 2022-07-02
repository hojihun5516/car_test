package service;

import domain.Gear;

public class CarStatusDto {

    String name;
    String number;
    int speed;
    Gear gear;

    public CarStatusDto(String name, String number, int speed, Gear gear) {
        this.name = name;
        this.number = number;
        this.speed = speed;
        this.gear = gear;
    }
}
