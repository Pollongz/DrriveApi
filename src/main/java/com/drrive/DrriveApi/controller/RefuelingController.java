package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.Refueling;
import com.drrive.DrriveApi.service.RefuelingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/refueling")
public class RefuelingController {

    private final RefuelingService refuelingService;

    @Autowired
    public RefuelingController(RefuelingService refuelingService) {
        this.refuelingService = refuelingService;
    }

    @GetMapping
    public List<Refueling> getRefueling() {
        return refuelingService.getRefuelings();
    }

    @GetMapping(path = "/{idRefueling}")
    public Refueling getOneRefueling(@PathVariable Integer idRefueling) {
        return refuelingService.getRefuelingById(idRefueling);
    }

    @PostMapping
    public void addNewRefueling(@RequestBody Refueling refueling) {
        refuelingService.addNewRefueling(refueling);
    }

    @DeleteMapping(path = "/{idRefueling}")
    public void deleteRefueling(@PathVariable Integer idRefueling) {
        refuelingService.deleteRefueling(idRefueling);
    }

    @PutMapping(path = "/{idRefueling}")
    public String updateRefueling(@RequestBody Refueling refueling) {
        refuelingService.updateRefueling(refueling);
        return "Refueling edited successfully!";
    }
}
