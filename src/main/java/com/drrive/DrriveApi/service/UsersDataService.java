package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Company;
import com.drrive.DrriveApi.entity.UsersData;
import com.drrive.DrriveApi.rest.UsersDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersDataService {
    
    private final UsersDataRepository usersDataRepository;

    @Autowired
    public UsersDataService(UsersDataRepository usersDataRepository) {
        this.usersDataRepository = usersDataRepository;
    }

    public List<UsersData> getUsers() {
        return usersDataRepository.findAll();
    }

    public List<UsersData> getCompanyEmployees(Company company) {
        return usersDataRepository.findEmployeesFromCompany(company);
    }

    public UsersData getUserById(Integer idUserData) {
        return usersDataRepository.findById(idUserData)
                .orElseThrow(() -> new IllegalStateException(
                        "UsersData with id: " + idUserData + "doesn't exist."
                ));
    }

    public void addNewUser(UsersData usersData) {
        usersDataRepository.save(usersData);
    }

    public void deleteUser(Integer idUserData) {
        boolean exists = usersDataRepository.existsById(idUserData);
        if (!exists) {
            throw new IllegalStateException("UsersData with id: " + idUserData + "doesn't exist.");
        }
        usersDataRepository.deleteById(idUserData);
    }

    public void updateUser(UsersData usersData) {
        UsersData existingUser = usersDataRepository.findById(usersData.getIdUserData())
                .orElseThrow(() -> new IllegalStateException(
                        "UsersData with id: " + usersData.getIdUserData() + " doesn't exist."
                ));
        existingUser.setFirstName(usersData.getFirstName());
        existingUser.setLastName(usersData.getLastName());
        existingUser.setPhoneNumber(usersData.getPhoneNumber());
        //existingUser.setLoginData(usersData.getLoginData());

        usersDataRepository.save(existingUser);
    }
}
