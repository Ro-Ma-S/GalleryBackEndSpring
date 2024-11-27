package com.example.artSellingProject_postgresql._1controller;

import com.example.artSellingProject_postgresql._2service.service_paymentTransaction;
import com.example.artSellingProject_postgresql.table_model.table_paymentTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("payments_ArtProj")
public class controller_paymentTransaction {

    @Autowired
    private service_paymentTransaction paymentService;

    @GetMapping("/allTransactions")
    public List<table_paymentTransaction> getAllTransactions() {
        return paymentService.getAllTransactions();
    }

    @GetMapping("/transactionId/{transaction_id}")
    public Optional<table_paymentTransaction> getTransactionById(@PathVariable Integer transaction_id) {
        return paymentService.getTransactionById(transaction_id);
    }

    @GetMapping("/orderId/{order_id}")
    public List<table_paymentTransaction> getTransactionsByOrderId(@PathVariable Integer order_id) {
        return paymentService.getTransactionsByOrderId(order_id);
    }

    @GetMapping("/userId/{user_id}")
    public List<table_paymentTransaction> getTransactionsByUserId(@PathVariable Integer user_id) {
        return paymentService.getTransactionsByUserId(user_id);
    }

    // New: Accessing transactions by date
    @GetMapping("/transactionDate/{transaction_date}")
    public List<table_paymentTransaction> getTransactionsByDate(@PathVariable String transaction_date) {
        LocalDate date = LocalDate.parse(transaction_date); // Convert string to LocalDate
        return paymentService.getTransactionsByDate(date);
    }

    @GetMapping("/paymentStatus/{status}")
    public List<table_paymentTransaction> getPaymentByStatus(@PathVariable String status) {
        return paymentService.getPaymentByStatus(status);
    }

    @PostMapping("/add")
    public String addTransaction(@RequestBody table_paymentTransaction transaction) {
        return paymentService.addTransaction(transaction);
    }

    @PutMapping("/update")
    public String updateTransaction(@RequestBody table_paymentTransaction transaction) {
        return paymentService.updateTransaction(transaction);
    }

    @DeleteMapping("/delete")
    public String deleteTransaction(@RequestBody table_paymentTransaction transaction) {
        return paymentService.deleteTransaction(transaction);
    }
}
