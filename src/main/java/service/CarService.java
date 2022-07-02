package service;

import domain.Car;
import domain.Gear;
import exception.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarService {
    Map<Long, Car> carMap = new HashMap<Long, Car>();
    Long carIndex = Long.valueOf(0);
    public CarStatusDto findOne(Long id){
        Car car = findOneById(id);
        return new CarStatusDto(car.getName(), car.getNumber(), car.currentSpeed(), car.currentGear());
    }

    public List<CarStatusDto> findAll() {
        if (!existsCar()){
            throw new RuntimeException("등록된 차가 없습니다.");
        }
        return carMap.values().stream()
                .map(car -> new CarStatusDto(car.getName(), car.getNumber(), car.currentSpeed(), car.currentGear()))
                .collect(Collectors.toList());
    }

    public CarStatusDto moveCar(Long id, int speed) {
        Car car = findOneById(id);
        car.move(speed);
        return new CarStatusDto(car.getName(), car.getNumber(), car.currentSpeed(), car.currentGear());
    }

    public CarStatusDto changeGear(Long id,Gear gear) {
        Car car = findOneById(id);
        car.changeGear(gear);
        return new CarStatusDto(car.getName(), car.getNumber(), car.currentSpeed(), car.currentGear());
    }

    public CreateCarResponse createCar(CreateCarRequest createCarRequest) {
        Car car = new Car(carIndex, createCarRequest.getName(), createCarRequest.getNumber());
        carMap.put(carIndex, car);
        carIndex++;
        return new CreateCarResponse(carIndex, createCarRequest.getName(),createCarRequest.getNumber());
    }



    private Car findOneById(Long id){
        if (!carMap.containsKey(id)){
            throw new NotFoundException("찾으시는 차가 없습니다.");
        }
        return carMap.get(id);
    }
    private boolean existsCar(){
        if (carMap.size()==0){
            return false;
        }
        return true;
    }

}
