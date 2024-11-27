package com.example.artSellingProject_postgresql._2service;


import com.example.artSellingProject_postgresql._3repository_dao.dao_artworks;
import com.example.artSellingProject_postgresql.table_model.table_artworks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class service_artworks {

    @Autowired
    private dao_artworks artworksDao;


    public List<table_artworks> getAllArtworks() {
        return artworksDao.findAll();
    }

    public Optional<table_artworks> getArtworkById(Integer artworkId) {
        return artworksDao.findById(artworkId);
    }

    public List<table_artworks> getArtworksByCategory(String category) {
        return artworksDao.findByCategory(category);
    }

    public List<table_artworks> getArtworksByUserId(Integer userId) {

        return artworksDao.findByUserId(userId);
    }

    public List<table_artworks> getArtworksByStyle(String style) {
        return artworksDao.findByStyle(style);
    }

    public List<table_artworks> getArtworksByCreationDate(String creationDate) {
        return artworksDao.findByCreationDate(creationDate);
    }

    public String addArtwork(table_artworks artworks) {
        artworksDao.save(artworks);
        return "Artwork added successfully";
    }

    public String updateArtwork(table_artworks artworks) {
        if(artworksDao.existsById(artworks.getArtworkId())){
            artworksDao.save(artworks);
            return "Artwork updated Successfully";
        }
        else {
            return "Artwork not found";
        }
    }

    public String deleteArtwork(table_artworks artworks) {
        if(artworksDao.existsById(artworks.getArtworkId())){
            artworksDao.save(artworks);
            return "Artwork deleted Successfully";
        }
        else {
            return "Artwork not found";
        }
    }
}
