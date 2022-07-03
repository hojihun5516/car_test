package domain;

import java.util.Objects;

public class Car {
    private final Long id;
    private final String name;
    private final String number;
    private int speed;
    private Gear gear = Gear.PARK;

    public Car(Long id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public void move(int speed) {
        if (validateSpeed(speed)) {
            throw new RuntimeException("속도를 1이상으로 변경해주세요");
        }
        if (Gear.movable(this.gear)) {
            this.speed += speed;
        }
    }

    public void changeGear(Gear gear) {
        if (this.speed != 0) {
            return;
        }
        this.gear = gear;
    }

    private boolean validateSpeed(int speed) {
        return speed < 1;
    }

    private String getLabel() {
        return this.gear.getLabel();
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }

    public int getSpeed() {
        return this.speed;
    }

    public Gear getGear() {
        return this.gear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", speed=" + speed +
                ", gear=" + gear +
                '}';
    }
}
