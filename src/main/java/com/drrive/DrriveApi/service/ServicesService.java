package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.Services;
import com.drrive.DrriveApi.rest.CarRepository;
import com.drrive.DrriveApi.rest.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService {
    
    private final ServicesRepository servicesRepository;
    private final CarRepository carRepository;

    @Autowired
    public ServicesService(ServicesRepository servicesRepository, CarRepository carRepository) {
        this.servicesRepository = servicesRepository;
        this.carRepository = carRepository;
    }

    public List<Services> getServices() {
        return servicesRepository.findAll();
    }

    public List<Services> getCarsServices(Car car) {
        return servicesRepository.findServicesFromCar(car);
    }

    public Services getServicesById(Integer idServices) {
        return servicesRepository.findById(idServices)
                .orElseThrow(() -> new IllegalStateException(
                        "Service with id: " + idServices + "doesn't exist."
                ));
    }

    public void addNewServices(Services services) {
        services.setCar(carRepository.getOne(services.getCarId()));
        servicesRepository.save(services);
    }

    public void deleteServices(Integer idServices) {
        boolean exists = servicesRepository.existsById(idServices);
        if (!exists) {
            throw new IllegalStateException("Service with id: " + idServices + "doesn't exist.");
        }
        servicesRepository.deleteById(idServices);
    }

    public void updateServices(Services services) {
        Services existingServices = servicesRepository.findById(services.getIdServices())
                .orElseThrow(() -> new IllegalStateException(
                        "Service with id: " + services.getIdServices() + "doesn't exist."
                ));
        existingServices.setServiceType(services.getServiceType());
        existingServices.setServiceCost(services.getServiceCost());
        existingServices.setMileage(services.getMileage());
        existingServices.setDate(services.getDate());
        existingServices.setCar(carRepository.getOne(services.getCarId()));

        servicesRepository.save(existingServices);
    }
}