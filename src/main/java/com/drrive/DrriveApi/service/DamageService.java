package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.Damage;
import com.drrive.DrriveApi.rest.CarRepository;
import com.drrive.DrriveApi.rest.DamageRepository;
import com.drrive.DrriveApi.rest.UsersDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageService {
    
    private final DamageRepository damageRepository;
    private final CarRepository carRepository;
    private final UsersDataRepository usersDataRepository;


    @Autowired
    public DamageService(DamageRepository damageRepository, CarRepository carRepository, UsersDataRepository usersDataRepository) {
        this.damageRepository = damageRepository;
        this.carRepository = carRepository;
        this.usersDataRepository = usersDataRepository;
    }

    public List<Damage> getDamages() {
        return damageRepository.findAll();
    }

    public List<Damage> getCarsDamages(Car car) {
        return damageRepository.findDamagesFromCar(car);
    }

    public Damage getDamagesById(Integer idDamage) {
        return damageRepository.findById(idDamage)
                .orElseThrow(() -> new IllegalStateException(
                        "Damage with id: " + idDamage + "doesn't exist."
                ));
    }

    public Damage addNewDamage(Damage damage) {
        damage.setCar(carRepository.getOne(damage.getCarId()));
        damage.setReportedBy(usersDataRepository.getOne(damage.getReportedById()));
        return damageRepository.save(damage);
    }

    public void deleteDamage(Integer idDamage) {
        boolean exists = damageRepository.existsById(idDamage);
        if (!exists) {
            throw new IllegalStateException("Damage with id: " + idDamage + "doesn't exist.");
        }

        damageRepository.deleteById(idDamage);
    }

    public String updateDamage(Damage damage) {
        Damage existingDamage = damageRepository.findById(damage.getIdDamage())
                .orElseThrow(() -> new IllegalStateException(
                        "Damage with id: " + damage.getIdDamage() + "doesn't exist."
                ));
        existingDamage.setDescription(damage.getDescription());
        existingDamage.setDate(damage.getDate());
        existingDamage.setCar(carRepository.getOne(damage.getCarId()));
        existingDamage.setReportedBy(usersDataRepository.getOne(damage.getReportedById()));

        damageRepository.save(existingDamage);
        return "Damage edited successfully!";
    }
}
