package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Refueling;
import com.drrive.DrriveApi.rest.RefuelingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefuelingService {
    
    private final RefuelingRepository refuelingRepository;

    @Autowired
    public RefuelingService(RefuelingRepository refuelingRepository) {
        this.refuelingRepository = refuelingRepository;
    }

    public List<Refueling> getRefuelings() {
        return refuelingRepository.findAll();
    }

    public Refueling getRefuelingById(Integer idRefueling) {
        return refuelingRepository.findById(idRefueling)
                .orElseThrow(() -> new IllegalStateException(
                        "Refueling with id: " + idRefueling + "doesn't exist."
                ));
    }

    public void addNewRefueling(Refueling refueling) {
        refuelingRepository.save(refueling);
    }

    public void deleteRefueling(Integer idRefueling) {
        boolean exists = refuelingRepository.existsById(idRefueling);
        if (!exists) {
            throw new IllegalStateException("Refueling with id: " + idRefueling + "doesn't exist.");
        }
        refuelingRepository.deleteById(idRefueling);
    }

    public Refueling updateRefueling(Refueling refueling) {
        Refueling existingRefueling = refuelingRepository.findById(refueling.getIdRefueling())
                .orElseThrow(() -> new IllegalStateException(
                        "Refueling with id: " + refueling.getIdRefueling() + "doesn't exist."
                ));
        existingRefueling.setFuelType(refueling.getFuelType());
        existingRefueling.setFuelQuantity(refueling.getFuelQuantity());
        existingRefueling.setFuelCost(refueling.getFuelCost());
        existingRefueling.setMileage(refueling.getMileage());
        existingRefueling.setDate(refueling.getDate());
        existingRefueling.setCar(refueling.getCar());

        return refuelingRepository.save(existingRefueling);
    }
}