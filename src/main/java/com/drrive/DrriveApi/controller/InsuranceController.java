package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.Insurance;
import com.drrive.DrriveApi.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/insurance")
public class InsuranceController {

    private final InsuranceService insuranceService;

    @Autowired
    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping
    public List<Insurance> getInsurance() {
        return insuranceService.getInsurance();
    }

    @GetMapping(path = "/{idInsurance}")
    public Insurance getOneInsurance(@PathVariable Integer idInsurance) {
        return insuranceService.getInsuranceById(idInsurance);
    }

    @PostMapping
    public void addNewInsurance(@RequestBody Insurance insurance) {
        insuranceService.addNewAddres(insurance);
    }

    @DeleteMapping(path = "/{idInsurance}")
    public void deleteInsurance(@PathVariable Integer idInsurance) {
        insuranceService.deleteInsurance(idInsurance);
    }

    @PutMapping(path = "/{idInsurance}")
    public String updateInsurance(@RequestBody Insurance insurance) {
        return insuranceService.updateInsurance(insurance);
    }
}
