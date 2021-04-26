package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.Damage;
import com.drrive.DrriveApi.rest.CarRepository;
import com.drrive.DrriveApi.rest.DamageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageService {
    
    private final DamageRepository damageRepository;
    private final CarRepository carRepository;


    @Autowired
    public DamageService(DamageRepository damageRepository, CarRepository carRepository) {
        this.damageRepository = damageRepository;
        this.carRepository = carRepository;
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

    public void addNewDamage(Damage damage) {
        damage.setCar(carRepository.getOne(damage.getCarId()));
        damageRepository.save(damage);
    }

    public void deleteDamage(Integer idDamage) {
        boolean exists = damageRepository.existsById(idDamage);
        if (!exists) {
            throw new IllegalStateException("Damage with id: " + idDamage + "doesn't exist.");
        }

        damageRepository.deleteById(idDamage);
    }

    public void updateDamage(Damage damage) {
        Damage existingDamage = damageRepository.findById(damage.getIdDamage())
                .orElseThrow(() -> new IllegalStateException(
                        "Damage with id: " + damage.getIdDamage() + "doesn't exist."
                ));
        existingDamage.setDescription(damage.getDescription());
        existingDamage.setCar(damage.getCar());

        damageRepository.save(existingDamage);
    }
}
