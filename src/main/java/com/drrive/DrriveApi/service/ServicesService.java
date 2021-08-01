package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.Refueling;
import com.drrive.DrriveApi.entity.Services;
import com.drrive.DrriveApi.rest.CarRepository;
import com.drrive.DrriveApi.rest.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public List<Services> getServicesFromCarFromTo(Car car, Date from_date, Date to_date) {
        List<Services> services = servicesRepository.findServicesFromCarFromTo(car, from_date, to_date);

        if (services == null) {
            throw new IllegalStateException("No services between " + from_date + " and " + to_date + " for a car with id: " + car);
        } else {
            return services;
        }
    }

    public Services getServicesById(Integer idServices) {
        return servicesRepository.findById(idServices)
                .orElseThrow(() -> new IllegalStateException(
                        "Service with id: " + idServices + "doesn't exist."
                ));
    }

    public Services addNewServices(Services services) {
        services.setCar(carRepository.getOne(services.getCarId()));
        return servicesRepository.save(services);
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
        existingServices.setDescription(services.getDescription());
        existingServices.setServiceCost(services.getServiceCost());
        existingServices.setMileage(services.getMileage());
        existingServices.setDate(services.getDate());
        existingServices.setCar(carRepository.getOne(services.getCarId()));

        servicesRepository.save(existingServices);
    }
}