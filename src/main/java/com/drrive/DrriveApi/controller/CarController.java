package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.*;
import com.drrive.DrriveApi.service.*;
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
    private final PlannedServicesService plannedServicesService;

    @Autowired
    public CarController(CarService carService, DamageService damageService, RefuelingService refuelingService, ServicesService servicesService, PlannedServicesService plannedServicesService) {
        this.carService = carService;
        this.damageService = damageService;
        this.refuelingService = refuelingService;
        this.servicesService = servicesService;
        this.plannedServicesService = plannedServicesService;
    }

    @GetMapping
    public List<Car> getCar() {
        return carService.getCars();
    }

    @GetMapping(path = "/{car}/damages")
    public List<Damage> getCarsDamages(@PathVariable Car car) {
        return damageService.getCarsDamages(car);
    }

    @GetMapping(path = "/{car}/refuelings")
    public List<Refueling> getCarsRefuelings(@PathVariable Car car) {
        return refuelingService.getCarsRefuelings(car);
    }

    @GetMapping(path = "/{car}/services")
    public List<Services> getCarsServices(@PathVariable Car car) {
        return servicesService.getCarsServices(car);
    }

    @GetMapping(path = "/{car}/planned")
    public List<PlannedService> getCarsPlannedServices(@PathVariable Car car) {
        return plannedServicesService.getCarsPlannedServices(car);
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
    public String deleteCar(@PathVariable Integer idCar) {
        return carService.deleteCar(idCar);
    }

    @PutMapping(path = "/{idCar}")
    public String updateCar(@RequestBody Car car) {
        return carService.updateCar(car);
    }
}
