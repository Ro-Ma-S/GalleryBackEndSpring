package com.example.artSellingProject_postgresql._3repository_dao;

import com.example.artSellingProject_postgresql.table_model.table_gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface dao_gallery extends JpaRepository<table_gallery,Integer> {

    Optional<table_gallery> findById(Integer gallery_id);

    List<table_gallery> findByUserId(Integer userId);
}
