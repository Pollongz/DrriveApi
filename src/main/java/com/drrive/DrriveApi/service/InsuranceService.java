package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Insurance;
import com.drrive.DrriveApi.rest.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;

    @Autowired
    public InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public List<Insurance> getInsurance() {
        return insuranceRepository.findAll();
    }

    public Insurance getInsuranceById(Integer idInsurance) {
        return insuranceRepository.findById(idInsurance).orElse(null);
    }

    public void addNewAddres(Insurance insurance) {
        insuranceRepository.save(insurance);
    }

    public void deleteInsurance(Integer idInsurance) {
        boolean exists = insuranceRepository.existsById(idInsurance);
        if (!exists) {
            throw new IllegalStateException("Insurance with id: " + idInsurance + "doesn't exist.");
        }

        insuranceRepository.deleteById(idInsurance);
    }

    public String updateInsurance(Insurance insurance) {
        Insurance existingInsurance = insuranceRepository.findById(insurance.getIdInsurance())
                .orElseThrow(() -> new IllegalStateException(
                        "Insurance with id: " + insurance.getIdInsurance() + "doesn't exist."
                ));
        existingInsurance.setPolicyNumber(insurance.getPolicyNumber());
        existingInsurance.setAssistanceNumber(insurance.getAssistanceNumber());

        insuranceRepository.save(existingInsurance);
        return "Insurance data edited successfully!";
    }
}
