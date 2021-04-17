package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.rest.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Integer idCar) {
        return carRepository.findById(idCar)
                .orElseThrow(() -> new IllegalStateException(
                        "Car with id: " + idCar + "doesn't exist."
                ));
    }

    public void addNewCar(Car car) {
        carRepository.save(car);
    }

    public void deleteCar(Integer idCar) {
        boolean exists = carRepository.existsById(idCar);
        if (!exists) {
            throw new IllegalStateException("Car with id: " + idCar + "doesn't exist.");
        }

        carRepository.deleteById(idCar);
    }

    public Car updateCar(Car car) {
        Car existingCar = carRepository.findById(car.getIdCar())
                .orElseThrow(() -> new IllegalStateException(
                        "Car with id: " + car.getIdCar() + "doesn't exist."
                ));
        existingCar.setCarBrand(car.getCarBrand());
        existingCar.setCarModel(car.getCarModel());
        existingCar.setCarManufactureYear(car.getCarManufactureYear());
        existingCar.setCarType(car.getCarType());
        existingCar.setEngineCapacity(car.getEngineCapacity());
        existingCar.setEnginePower(car.getEnginePower());
        existingCar.setPlateNumber(car.getPlateNumber());
        existingCar.setIsTaken(car.getIsTaken());
        existingCar.setCompany(car.getCompany());

        return carRepository.save(existingCar);
    }
}
