package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.Damage;
import com.drrive.DrriveApi.entity.Refueling;
import com.drrive.DrriveApi.rest.CarRepository;
import com.drrive.DrriveApi.rest.RefuelingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public List<Refueling> getRefuelingsFromCarFromTo(Car car, Date from_date, Date to_date) {
        List<Refueling> refuelings = refuelingRepository.findRefuelingsFromCarFromTo(car, from_date, to_date);

        if (refuelings == null) {
            throw new IllegalStateException("No refuelings between " + from_date + " and " + to_date + " for a car with id: " + car);
        } else {
            return refuelings;
        }
    }

    public Refueling getRefuelingById(Integer idRefueling) {
        return refuelingRepository.findById(idRefueling)
                .orElseThrow(() -> new IllegalStateException(
                        "Refueling with id: " + idRefueling + "doesn't exist."
                ));
    }

    public Refueling addNewRefueling(Refueling refueling) {
        refueling.setCar(carRepository.getOne(refueling.getCarId()));
        return refuelingRepository.save(refueling);
    }

    public void deleteRefueling(Integer idRefueling) {
        boolean exists = refuelingRepository.existsById(idRefueling);
        if (!exists) {
            throw new IllegalStateException("Refueling with id: " + idRefueling + "doesn't exist.");
        }
        refuelingRepository.deleteById(idRefueling);
    }

    public String updateRefueling(Refueling refueling) {
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
        return "Refueling edited successfully!";
    }
}