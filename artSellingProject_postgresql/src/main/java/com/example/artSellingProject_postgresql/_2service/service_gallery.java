package com.example.artSellingProject_postgresql._2service;

import com.example.artSellingProject_postgresql._3repository_dao.dao_gallery;
import com.example.artSellingProject_postgresql.table_model.table_gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class service_gallery {

    @Autowired
    private dao_gallery galleryDao;


    public List<table_gallery> getAllGalleries() {
        return galleryDao.findAll();
    }

    public Optional<table_gallery> getGalleryById(Integer galleryId) {
        return galleryDao.findById(galleryId);
    }

    public List<table_gallery> getGalleryByUserId(Integer userId) {
        return  galleryDao.findByUserId(userId);
    }

    public String addGallery(table_gallery gallery) {

        galleryDao.save(gallery);
        return "Gallery added Successfully.";
    }

    public String updateGallery(table_gallery gallery) {
        if(galleryDao.existsById(gallery.getGalleryId())){
            galleryDao.save(gallery);
            return "Gallery updated Successfully";
        }
        else {
            return "Gallery not found";
        }
    }

    public String deleteGallery(table_gallery gallery) {
        if(galleryDao.existsById(gallery.getGalleryId())){
            galleryDao.save(gallery);
            return "Gallery deleted Successfully";
        }
        else {
            return "Gallery not found";
        }
    }
}
