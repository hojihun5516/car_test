package service;

public class CreateCarRequest {

    String name;
    String number;

    public CreateCarRequest(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
