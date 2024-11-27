package com.example.artSellingProject_postgresql._3repository_dao;

import com.example.artSellingProject_postgresql.table_model.table_artworks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface dao_artworks extends JpaRepository<table_artworks, Integer> {

    Optional<table_artworks> findById(Integer artworkId);

    List<table_artworks> findByCategory(String category);

    List<table_artworks> findByStyle(String style);

    List<table_artworks> findByCreationDate(String creationDate);

    List<table_artworks> findByUserId(Integer userId);
}
