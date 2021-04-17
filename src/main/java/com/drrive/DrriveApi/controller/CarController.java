package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCar() {
        return carService.getCars();
    }

    @GetMapping(path = "/{idCar}")
    public Car getOneCar(@PathVariable Integer idCar) {
        return carService.getCarById(idCar);
    }

    @PostMapping
    public void addNewCar(@RequestBody Car car) {
        carService.addNewCar(car);
    }

    @DeleteMapping(path = "/{idCar}")
    public void deleteCar(@PathVariable Integer idCar) {
        carService.deleteCar(idCar);
    }

    @PutMapping(path = "/{idCar}")
    public String updateCar(@RequestBody Car car) {
        carService.updateCar(car);
        return "Car edited successfully!";
    }
}
