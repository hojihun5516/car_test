package controller;

import domain.Gear;
import service.CarService;
import service.CarStatusDto;
import service.CreateCarRequest;
import service.CreateCarResponse;

import java.util.List;

public class CarController {
    CarService carService = new CarService();

    //POST("/car")
    public CreateCarResponse createCar(CreateCarRequest createCarRequest){
        return carService.createCar(createCarRequest);
    }

    //GET("/car/{id}")
    public CarStatusDto findOne(Long id){
        return carService.findOne(id);
    }

    //GET("/cars")
    public List<CarStatusDto> getCarStatus(){
        return carService.findAll();
    }

    //POST("/car/move")
    public CarStatusDto moveCar(Long id, int speed) {
        return carService.moveCar(id, speed);
    }
    //POST("/car/gear")
    public CarStatusDto changeGear(Long id, Gear gear){
        return carService.changeGear(id, gear);
    }
}
