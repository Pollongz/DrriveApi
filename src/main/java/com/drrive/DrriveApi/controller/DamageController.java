package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.Damage;
import com.drrive.DrriveApi.entity.Photo;
import com.drrive.DrriveApi.service.DamageService;
import com.drrive.DrriveApi.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/damage")
public class DamageController {

    private final DamageService damageService;
    private final PhotoService photoService;

    @Autowired
    public DamageController(DamageService damageService, PhotoService photoService) {
        this.damageService = damageService;
        this.photoService = photoService;
    }

    @GetMapping
    public List<Damage> getDamages() {
        return damageService.getDamages();
    }

    @GetMapping(path = "/{damage}/photos")
    public List<Photo> getDamagesPhotos(@PathVariable Damage damage) {
        return photoService.getDamagesPhotos(damage);
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
        return damageService.updateDamage(damage);
    }
}
