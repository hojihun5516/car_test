package service;

public class CreateCarResponse {
    private Long id;
    private String name;
    private String number;

    public CreateCarResponse(Long id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }
}
