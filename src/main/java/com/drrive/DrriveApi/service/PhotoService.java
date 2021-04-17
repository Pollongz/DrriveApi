package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.Company;
import com.drrive.DrriveApi.entity.Damage;
import com.drrive.DrriveApi.entity.Photo;
import com.drrive.DrriveApi.rest.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {
    
    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
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
        photoRepository.save(photo);
    }

    public void deletePhoto(Integer idPhoto) {
        boolean exists = photoRepository.existsById(idPhoto);
        if (!exists) {
            throw new IllegalStateException("Photo with id: " + idPhoto + "doesn't exist.");
        }
        photoRepository.deleteById(idPhoto);
    }

    public Photo updatePhoto(Photo photo) {
        Photo existingPhoto = photoRepository.findById(photo.getIdPhoto())
                .orElseThrow(() -> new IllegalStateException(
                        "Photo with id: " + photo.getIdPhoto() + "doesn't exist."
                ));
        existingPhoto.setPhotoUrl(photo.getPhotoUrl());
        //existingPhoto.setDamage(photo.getDamage());

        return photoRepository.save(existingPhoto);
    }
}
