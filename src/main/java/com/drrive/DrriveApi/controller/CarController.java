package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.*;
import com.drrive.DrriveApi.service.CarService;
import com.drrive.DrriveApi.service.DamageService;
import com.drrive.DrriveApi.service.RefuelingService;
import com.drrive.DrriveApi.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/car")
public class CarController {

    private final CarService carService;
    private final DamageService damageService;
    private final RefuelingService refuelingService;
    private final ServicesService servicesService;

    @Autowired
    public CarController(CarService carService, DamageService damageService, RefuelingService refuelingService, ServicesService servicesService) {
        this.carService = carService;
        this.damageService = damageService;
        this.refuelingService = refuelingService;
        this.servicesService = servicesService;
    }

    @GetMapping
    public List<Car> getCar() {
        return carService.getCars();
    }

    @GetMapping(path = "/{id_car}/damages")
    public List<Damage> getCarsDamages(@PathVariable Integer id_car) {
        return damageService.getCarsDamages(id_car);
    }

    @GetMapping(path = "/{id_car}/refuelings")
    public List<Refueling> getCarsRefuelings(@PathVariable Integer id_car) {
        return refuelingService.getCarsRefuelings(id_car);
    }

    @GetMapping(path = "/{id_car}/services")
    public List<Services> getCarsServices(@PathVariable Integer id_car) {
        return servicesService.getCarsServices(id_car);
    }

    @GetMapping(path = "/available")
    public List<Car> getAvailableCars() {
        return carService.getAvailableCars();
    }

    @GetMapping(path = "/taken")
    public List<Car> getTakenCars() {
        return carService.getTakenCars();
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
