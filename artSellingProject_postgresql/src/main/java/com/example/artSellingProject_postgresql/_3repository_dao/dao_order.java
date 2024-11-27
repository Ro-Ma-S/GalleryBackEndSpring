package com.example.artSellingProject_postgresql._3repository_dao;

import com.example.artSellingProject_postgresql.table_model.table_order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface dao_order extends JpaRepository<table_order,Integer> {

    Optional<table_order> findById(Integer orderId);

    List<table_order> findByUserId(Integer userId);

    List<table_order> findByArtworkId(Integer artworkId);

    List<table_order> findByStatus(String status);
}
