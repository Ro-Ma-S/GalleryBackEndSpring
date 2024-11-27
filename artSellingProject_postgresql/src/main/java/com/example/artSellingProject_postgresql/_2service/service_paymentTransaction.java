package com.example.artSellingProject_postgresql._2service;

import com.example.artSellingProject_postgresql._3repository_dao.dao_paymentTransaction;
import com.example.artSellingProject_postgresql.table_model.table_paymentTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class service_paymentTransaction {

    @Autowired
    private dao_paymentTransaction paymentTransactionsDao;

    public List<table_paymentTransaction> getAllTransactions() {
        return paymentTransactionsDao.findAll();
    }

    public Optional<table_paymentTransaction> getTransactionById(Integer transactionId) {
        return paymentTransactionsDao.findByTransactionId(transactionId);
    }

    public List<table_paymentTransaction> getTransactionsByOrderId(Integer orderId) {
        return paymentTransactionsDao.findByOrderId(orderId);
    }

    public List<table_paymentTransaction> getTransactionsByUserId(Integer userId) {
        return paymentTransactionsDao.findByUserId(userId);
    }

    public List<table_paymentTransaction> getTransactionsByDate(LocalDate transactionDate) {
        return paymentTransactionsDao.findByTransactionDate(transactionDate);
    }

    public List<table_paymentTransaction> getPaymentByStatus(String status) {
        return paymentTransactionsDao.findByStatus(status);
    }

    public String addTransaction(table_paymentTransaction transaction) {
        paymentTransactionsDao.save(transaction);
        return "Transaction added successfully!";
    }

    public String updateTransaction(table_paymentTransaction transaction) {
        if (paymentTransactionsDao.existsById(transaction.getTransactionId())) {
            paymentTransactionsDao.save(transaction);
            return "Transaction updated successfully!";
        } else {
            return "Transaction not found!";
        }
    }


    public String deleteTransaction(table_paymentTransaction transaction) {
        if (paymentTransactionsDao.existsById(transaction.getTransactionId())) {
            paymentTransactionsDao.save(transaction);
            return "Transaction Deleted successfully!";
        } else {
            return "Transaction not found!";
        }
    }
}
