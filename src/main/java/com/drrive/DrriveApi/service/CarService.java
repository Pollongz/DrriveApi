package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.Company;
import com.drrive.DrriveApi.entity.Insurance;
import com.drrive.DrriveApi.rest.CarRepository;
import com.drrive.DrriveApi.rest.CompanyRepository;
import com.drrive.DrriveApi.rest.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CompanyRepository companyRepository;
    private final InsuranceRepository insuranceRepository;

    @Autowired
    public CarService(CarRepository carRepository, CompanyRepository companyRepository, InsuranceRepository insuranceRepository) {
        this.carRepository = carRepository;
        this.companyRepository = companyRepository;
        this.insuranceRepository = insuranceRepository;
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public List<Car> getCompanyCars(Company company) {
        return carRepository.findCarsFromCompany(company);
    }

    public List<Car> getAvailableCars() {
        return carRepository.findAvailableCars();
    }

    public List<Car> getTakenCars() {
        return carRepository.findTakenCars();
    }

    public Car getCarById(Integer idCar) {
        return carRepository.findById(idCar)
                .orElseThrow(() -> new IllegalStateException(
                        "Car with id: " + idCar + "doesn't exist."
                ));
    }

    public Car addNewCar(Car car) {
        car.setCompany(companyRepository.getOne(car.getCompanyId()));
        car.setInsurance(insuranceRepository.getOne(car.getInsuranceId()));
        return carRepository.save(car);
    }

    public String deleteCar(Integer idCar) {
        boolean exists = carRepository.existsById(idCar);
        if (!exists) {
            throw new IllegalStateException("Car with id: " + idCar + "doesn't exist.");
        }

        carRepository.deleteById(idCar);
        return "Car deleted successfully!";
    }

    public String updateCar(Car car) {
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
        existingCar.setCompany(companyRepository.getOne(car.getCompanyId()));
        existingCar.setInsurance(insuranceRepository.getOne(car.getInsuranceId()));

        carRepository.save(existingCar);
        return "Car edited successfully!";
    }
}
