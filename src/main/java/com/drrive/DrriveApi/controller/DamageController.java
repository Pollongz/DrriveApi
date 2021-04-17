package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.Damage;
import com.drrive.DrriveApi.entity.User;
import com.drrive.DrriveApi.service.DamageService;
import com.drrive.DrriveApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/damage")
public class DamageController {

    private final DamageService damageService;

    @Autowired
    public DamageController(DamageService damageService) {
        this.damageService = damageService;
    }

    @GetMapping
    public List<Damage> getDamages() {
        return damageService.getDamages();
    }

    @GetMapping(path = "/{idDamage}")
    public Damage getOneDamage(@PathVariable Integer idDamage) {
        return damageService.getDamagesById(idDamage);
    }

    @PostMapping
    public void addNewDamage(@RequestBody Damage damage) {
        damageService.addNewDamage(damage);
    }

    @DeleteMapping(path = "/{idDamage}")
    public void deleteDamage(@PathVariable Integer idDamage) {
        damageService.deleteDamage(idDamage);
    }

    @PutMapping(path = "/{idDamage}")
    public String updateDamage(@RequestBody Damage damage, @PathVariable Integer idDamage) {
        damageService.updateDamage(damage);
        return "Damage edited successfully!";
    }
}
