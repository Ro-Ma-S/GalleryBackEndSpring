package com.example.artSellingProject_postgresql._3repository_dao;

import com.example.artSellingProject_postgresql.table_model.table_paymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface dao_paymentTransaction extends JpaRepository<table_paymentTransaction,Integer> {

    // Method to find a transaction by its ID
    Optional<table_paymentTransaction> findByTransactionId(Integer transactionId);

    // Method to find transactions by order ID
    List<table_paymentTransaction> findByOrderId(Integer orderId);

    // Method to find transactions by user ID
    List<table_paymentTransaction> findByUserId(Integer userId);

    // New method to find transactions by date
    List<table_paymentTransaction> findByTransactionDate(LocalDate transactionDate);

    List<table_paymentTransaction> findByStatus(String status);
    
}
