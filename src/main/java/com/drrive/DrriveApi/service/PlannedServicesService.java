package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.PlannedService;
import com.drrive.DrriveApi.rest.CarRepository;
import com.drrive.DrriveApi.rest.PlannedServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlannedServicesService {

    private final PlannedServiceRepository plannedServiceRepository;
    private final CarRepository carRepository;

    @Autowired
    public PlannedServicesService(PlannedServiceRepository plannedServiceRepository, CarRepository carRepository) {
        this.plannedServiceRepository = plannedServiceRepository;
        this.carRepository = carRepository;
    }

    public List<PlannedService> getPlannedServices() {
        return plannedServiceRepository.findAll();
    }

    public PlannedService getPlannedServiceById(Integer idPlannedService) {
        return plannedServiceRepository.findById(idPlannedService)
                .orElseThrow(() -> new IllegalStateException(
                        "Planned service with id: " + idPlannedService + "doesn't exist."
                ));
    }

    public List<PlannedService> getCarsPlannedServices(Car car) {
        return plannedServiceRepository.findPlannedServicesFromCar(car);
    }

    public PlannedService addNewPlannedService(PlannedService plannedService) {
        plannedService.setCar(carRepository.getOne(plannedService.getCarId()));
        return plannedServiceRepository.save(plannedService);
    }

    public String deletePlannedService(Integer idPlannedService) {
        boolean exists = plannedServiceRepository.existsById(idPlannedService);
        if (!exists) {
            throw new IllegalStateException("Planned service with id: " + idPlannedService + "doesn't exist.");
        }
        plannedServiceRepository.deleteById(idPlannedService);

        return "Planned service deleted successfully!";
    }

    public PlannedService updatePlannedService(PlannedService plannedService) {
        PlannedService existingPlannedService = plannedServiceRepository.findById(plannedService.getIdPlannedService())
                .orElseThrow(() -> new IllegalStateException(
                        "Planned service with id: " + plannedService.getIdPlannedService() + "doesn't exist."
                ));
        existingPlannedService.setDescription(plannedService.getDescription());
        existingPlannedService.setDate(plannedService.getDate());
        existingPlannedService.setCar(carRepository.getOne(plannedService.getCarId()));

        return plannedServiceRepository.save(existingPlannedService);
    }
}
