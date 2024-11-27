package com.example.artSellingProject_postgresql._3repository_dao;

import com.example.artSellingProject_postgresql.table_model.table_users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface dao_users extends JpaRepository<table_users, Integer> {


    Optional<table_users> findById(Integer userId);

    List<table_users> findByCategory(String category);

    List<table_users> findByGender(String gender);
    
}
