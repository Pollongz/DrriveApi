package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.Refueling;
import com.drrive.DrriveApi.rest.CarRepository;
import com.drrive.DrriveApi.rest.RefuelingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefuelingService {
    
    private final RefuelingRepository refuelingRepository;
    private final CarRepository carRepository;

    @Autowired
    public RefuelingService(RefuelingRepository refuelingRepository, CarRepository carRepository) {
        this.refuelingRepository = refuelingRepository;
        this.carRepository = carRepository;
    }

    public List<Refueling> getRefuelings() {
        return refuelingRepository.findAll();
    }

    public List<Refueling> getCarsRefuelings(Car car) {
        return refuelingRepository.findRefuelingsFromCar(car);
    }

    public Refueling getRefuelingById(Integer idRefueling) {
        return refuelingRepository.findById(idRefueling)
                .orElseThrow(() -> new IllegalStateException(
                        "Refueling with id: " + idRefueling + "doesn't exist."
                ));
    }

    public void addNewRefueling(Refueling refueling) {
        refueling.setCar(carRepository.getOne(refueling.getCarId()));
        refuelingRepository.save(refueling);
    }

    public void deleteRefueling(Integer idRefueling) {
        boolean exists = refuelingRepository.existsById(idRefueling);
        if (!exists) {
            throw new IllegalStateException("Refueling with id: " + idRefueling + "doesn't exist.");
        }
        refuelingRepository.deleteById(idRefueling);
    }

    public void updateRefueling(Refueling refueling) {
        Refueling existingRefueling = refuelingRepository.findById(refueling.getIdRefueling())
                .orElseThrow(() -> new IllegalStateException(
                        "Refueling with id: " + refueling.getIdRefueling() + "doesn't exist."
                ));
        existingRefueling.setFuelType(refueling.getFuelType());
        existingRefueling.setFuelQuantity(refueling.getFuelQuantity());
        existingRefueling.setFuelCost(refueling.getFuelCost());
        existingRefueling.setMileage(refueling.getMileage());
        existingRefueling.setDate(refueling.getDate());
        existingRefueling.setCar(carRepository.getOne(refueling.getCarId()));

        refuelingRepository.save(existingRefueling);
    }
}