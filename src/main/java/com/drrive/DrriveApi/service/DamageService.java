package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Damage;
import com.drrive.DrriveApi.rest.DamageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageService {
    
    private final DamageRepository damageRepository;

    @Autowired
    public DamageService(DamageRepository damageRepository) {
        this.damageRepository = damageRepository;
    }

    public List<Damage> getDamages() {
        return damageRepository.findAll();
    }

    public Damage getDamagesById(Integer idDamage) {
        return damageRepository.findById(idDamage)
                .orElseThrow(() -> new IllegalStateException(
                        "Damage with id: " + idDamage + "doesn't exist."
                ));
    }

    public void addNewDamage(Damage damage) {
        damageRepository.save(damage);
    }

    public void deleteDamage(Integer idDamage) {
        boolean exists = damageRepository.existsById(idDamage);
        if (!exists) {
            throw new IllegalStateException("Damage with id: " + idDamage + "doesn't exist.");
        }

        damageRepository.deleteById(idDamage);
    }

    public Damage updateDamage(Damage damage) {
        Damage existingDamage = damageRepository.findById(damage.getIdDamage())
                .orElseThrow(() -> new IllegalStateException(
                        "Damage with id: " + damage.getIdDamage() + "doesn't exist."
                ));
        existingDamage.setDescription(damage.getDescription());
        existingDamage.setCar(damage.getCar());

        return damageRepository.save(existingDamage);
    }
}
