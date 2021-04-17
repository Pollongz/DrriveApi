package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Company;
import com.drrive.DrriveApi.rest.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompaniesById(Integer idCompany) {
        return companyRepository.findById(idCompany)
                .orElseThrow(() -> new IllegalStateException(
                        "Company with id: " + idCompany + "doesn't exist."
                ));
    }

    public void addNewCompany(Company company) {
        companyRepository.save(company);
    }

    public void deleteCompany(Integer idCompany) {
        boolean exists = companyRepository.existsById(idCompany);
        if (!exists) {
            throw new IllegalStateException("Company with id: " + idCompany + "doesn't exist.");
        }

        companyRepository.deleteById(idCompany);
    }

    public Company updateCompany(Company company) {
        Company existingCompany = companyRepository.findById(company.getIdCompany())
                .orElseThrow(() -> new IllegalStateException(
                        "Car with id: " + company.getIdCompany() + "doesn't exist."
                ));
        existingCompany.setName(company.getName());
        existingCompany.setNip(company.getNip());
        existingCompany.setAddress(company.getAddress());

        return companyRepository.save(existingCompany);
    }
}
