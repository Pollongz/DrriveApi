package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.PlannedService;
import com.drrive.DrriveApi.service.PlannedServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/planned")
public class PlannedServiceController {

    private final PlannedServicesService plannedServicesService;

    @Autowired
    public PlannedServiceController(PlannedServicesService plannedServicesService) {
        this.plannedServicesService = plannedServicesService;
    }

    @GetMapping
    public List<PlannedService> getPlannedService() {
        return plannedServicesService.getPlannedServices();
    }

    @GetMapping(path = "/{idPlannedService}")
    public PlannedService getOnePlannedService(@PathVariable("idPlannedService") Integer idPlannedService) {
        return plannedServicesService.getPlannedServiceById(idPlannedService);
    }

    @PostMapping
    public PlannedService addNewPlannedService(@RequestBody PlannedService plannedService) {
        return plannedServicesService.addNewPlannedService(plannedService);
    }

    @PostMapping(path = "/{idPlannedServicet}")
    public PlannedService updatePlannedService(@RequestBody PlannedService plannedService) {
        return plannedServicesService.updatePlannedService(plannedService);
    }

    @DeleteMapping(path = "/{idPlannedService}")
    public String deletePlannedService(@PathVariable("idPlannedService") Integer idPlannedService) {
        return plannedServicesService.deletePlannedService(idPlannedService);
    }
}
