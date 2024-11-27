package com.example.artSellingProject_postgresql._3repository_dao;


import com.example.artSellingProject_postgresql.table_model.table_bidding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface dao_bidding extends JpaRepository<table_bidding,Integer> {
    List<table_bidding> findByUserId(Integer userId);

    List<table_bidding> findByArtworkId(Integer artworkId);

    Optional<table_bidding> findById(Integer bidId);
}
