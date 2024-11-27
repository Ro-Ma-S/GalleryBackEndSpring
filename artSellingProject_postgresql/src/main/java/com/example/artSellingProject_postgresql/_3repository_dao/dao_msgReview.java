package com.example.artSellingProject_postgresql._3repository_dao;

import com.example.artSellingProject_postgresql.table_model.table_msgReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface dao_msgReview extends JpaRepository<table_msgReview,Integer> {

    Optional<table_msgReview> findById(Integer reviewId);

    List<table_msgReview> findByUserId(Integer userId);

    List<table_msgReview> findByArtworkId(Integer artworkId);

    List<table_msgReview> findByRating(Integer rating);
}
