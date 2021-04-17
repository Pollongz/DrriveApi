package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.Services;
import com.drrive.DrriveApi.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/service")
public class ServicesController {

    private final ServicesService serviceService;

    @Autowired
    public ServicesController(ServicesService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public List<Services> getServices() {
        return serviceService.getServices();
    }

    @GetMapping(path = "/{idServices}")
    public Services getOneServices(@PathVariable Integer idServices) {
        return serviceService.getServicesById(idServices);
    }

    @PostMapping
    public void addNewServices(@RequestBody Services service) {
        serviceService.addNewServices(service);
    }

    @DeleteMapping(path = "/{idServices}")
    public void deleteServices(@PathVariable Integer idServices) {
        serviceService.deleteServices(idServices);
    }

    @PutMapping(path = "/{idServices}")
    public String updateServices(@RequestBody Services service) {
        serviceService.updateServices(service);
        return "Service edited successfully!";
    }
}
