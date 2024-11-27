package com.example.artSellingProject_postgresql.table_model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@Table(name = "paymenttransactions_table")
public class table_paymentTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", unique = true, updatable = false)
    private Integer transactionId;

    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "payment_method",length = 50,nullable = true)
    private String paymentMethod;

    @Column(name = "transaction_date", nullable = false)
    private LocalDate transactionDate;

    @Column(name = "transaction_time", nullable = false)
    private LocalTime transactionTime;

    @Column(name = "amount", nullable = false,precision = 10,scale = 2)
    private BigDecimal amount;

    @Column(name = "status", nullable = true,length = 50)
    private String status;


    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

//    @UpdateTimestamp
//    @Column(name = "updated_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date updated_at;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private table_users user;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private table_order order;

}
