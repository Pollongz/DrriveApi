package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Damage;
import com.drrive.DrriveApi.entity.Photo;
import com.drrive.DrriveApi.rest.DamageRepository;
import com.drrive.DrriveApi.rest.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {
    
    private final PhotoRepository photoRepository;
    private final DamageRepository damageRepository;


    @Autowired
    public PhotoService(PhotoRepository photoRepository, DamageRepository damageRepository) {
        this.photoRepository = photoRepository;
        this.damageRepository = damageRepository;
    }

    public List<Photo> getPhotos() {
        return photoRepository.findAll();
    }

    public List<Photo> getDamagesPhotos(Damage damage) {
        return photoRepository.findPhotosFromDamage(damage);
    }

    public Photo getPhotoById(Integer idPhoto) {
        return photoRepository.findById(idPhoto)
                .orElseThrow(() -> new IllegalStateException(
                        "Photo with id: " + idPhoto + "doesn't exist."
                ));
    }

    public void addNewPhoto(Photo photo) {
        photo.setDamage(damageRepository.getOne(photo.getDamageId()));
        photoRepository.save(photo);
    }

    public void deletePhoto(Integer idPhoto) {
        boolean exists = photoRepository.existsById(idPhoto);
        if (!exists) {
            throw new IllegalStateException("Photo with id: " + idPhoto + "doesn't exist.");
        }
        photoRepository.deleteById(idPhoto);
    }

    public void updatePhoto(Photo photo) {
        Photo existingPhoto = photoRepository.findById(photo.getIdPhoto())
                .orElseThrow(() -> new IllegalStateException(
                        "Photo with id: " + photo.getIdPhoto() + "doesn't exist."
                ));
        existingPhoto.setPhotoUrl(photo.getPhotoUrl());
        existingPhoto.setDamage(damageRepository.getOne(photo.getDamageId()));

        photoRepository.save(existingPhoto);
    }
}
