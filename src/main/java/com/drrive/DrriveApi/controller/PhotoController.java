package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.Photo;
import com.drrive.DrriveApi.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/photo")
public class PhotoController {

    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping
    public List<Photo> getPhoto() {
        return photoService.getPhotos();
    }

    @GetMapping(path = "/{idPhoto}")
    public Photo getOnePhoto(@PathVariable Integer idPhoto) {
        return photoService.getPhotoById(idPhoto);
    }

    @PostMapping
    public Photo addNewPhoto(@RequestBody Photo photo) {
        return photoService.addNewPhoto(photo);
    }

    @DeleteMapping(path = "/{idPhoto}")
    public void deletePhoto(@PathVariable Integer idPhoto) {
        photoService.deletePhoto(idPhoto);
    }

    @PutMapping(path = "/{idPhoto}")
    public String updatePhoto(@RequestBody Photo photo) {
       return photoService.updatePhoto(photo);
    }
}
