package com.example.artSellingProject_postgresql._1controller;

import com.example.artSellingProject_postgresql._2service.service_gallery;
import com.example.artSellingProject_postgresql.table_model.table_gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gallery_ArtProj")
public class controller_gallery {

    @Autowired
    private service_gallery galleryService;

    @GetMapping("/allGalleries")
    public List<table_gallery> getAllGalleries() {
        return galleryService.getAllGalleries();
    }

    @GetMapping("/gallery_id/{gallery_id}")
    public Optional<table_gallery> getGalleryById(@PathVariable Integer gallery_id)
    {
        return galleryService.getGalleryById(gallery_id);
    }

    @GetMapping("/organiser_id/{user_id}")
    public List<table_gallery> getEventsByUserId(@PathVariable Integer user_id) {
        return galleryService.getGalleryByUserId(user_id);
    }

    @PostMapping("/add")
    public String addGallery(@RequestBody table_gallery gallery)
    {
        return galleryService.addGallery(gallery);
    }

    @PutMapping("/update")
    public String updateGallery(@RequestBody table_gallery gallery)
    {
        return galleryService.updateGallery(gallery);
    }

    @DeleteMapping("/delete")
    public String deleteGallery(@RequestBody table_gallery gallery)
    {
        return galleryService.deleteGallery(gallery);
    }

}
