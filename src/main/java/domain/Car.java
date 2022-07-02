package domain;

public class Car {
    private Long id;
    private String name;
    private String number;
    private int speed;
    private Gear gear = Gear.P;
    public Car(Long id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }
    public String getName(){
        return this.name;
    }
    public String getNumber(){
        return this.number;
    }
    public int currentSpeed(){
        return this.speed;
    }
    public Gear currentGear(){
        return this.gear;
    }

    public void move(int speed){
        if (!checkSpeed(speed) || checkGear(Gear.N) || checkGear(Gear.P)){
            throw new RuntimeException("움직일 수 없는 상태입니다");
        }
        if (checkGear(Gear.D)){
            this.speed += speed;
        }
        if (checkGear(Gear.R)){
            this.speed -= speed;
        }
    }

    public boolean changeGear(Gear gear){
        if (this.speed!=0){
            return false;
        }
        this.gear = gear;
        return true;
    }

    private boolean checkSpeed(int speed){
        if (speed<1){
            return false;
        }
        return true;
    }

    private boolean checkGear(Gear gear){
        if (this.gear == gear){
            return true;
        }
        return false;
    }

}
