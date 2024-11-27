package com.example.artSellingProject_postgresql._3repository_dao;

import com.example.artSellingProject_postgresql.table_model.table_events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface dao_events extends JpaRepository<table_events,Integer> {

    Optional<table_events> findById(Integer eventId);

    List<table_events> findByUserId(Integer userId);
}
