package com.example.artSellingProject_postgresql._1controller;

import com.example.artSellingProject_postgresql._2service.service_artworks;
import com.example.artSellingProject_postgresql.table_model.table_artworks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artworks_ArtProj")
public class controller_artworks {

    @Autowired
    private service_artworks artworksService;

    // Get all artworks
    @GetMapping("/allArtWorks")
    public List<table_artworks> getAllArtworks() {
        return artworksService.getAllArtworks();
    }

    @GetMapping("/artworkId/{artwork_id}")
    public Optional<table_artworks> getArtworkById(@PathVariable Integer artwork_id) {
        return artworksService.getArtworkById(artwork_id);
    }

    @GetMapping("/type/{category}")
    public List<table_artworks> getArtworksByCategory(@PathVariable String category) {
        return artworksService.getArtworksByCategory(category);
    }

    @GetMapping("/artist/{user_id}")
    public List<table_artworks> getArtworksByUserId(@PathVariable Integer user_id) {
        return artworksService.getArtworksByUserId(user_id);
    }

    @GetMapping("/style/{style}")
    public List<table_artworks> getArtworksByStyle(@PathVariable String style) {
        return artworksService.getArtworksByStyle(style);
    }

    @GetMapping("/creationDate/{creation_date}")
    public List<table_artworks> getArtworksByCreationDate(@PathVariable String creation_date) {
        return artworksService.getArtworksByCreationDate(creation_date);
    }

    @PostMapping("/add")
    public String addUser(@RequestBody table_artworks artworks) {
        return artworksService.addArtwork(artworks);
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody table_artworks artworks) {
        return artworksService.updateArtwork(artworks);
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestBody table_artworks artworks){
        return artworksService.deleteArtwork(artworks);
    }
}
