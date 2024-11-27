package com.example.artSellingProject_postgresql.table_model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name="bidding_table")
@Entity
public class table_bidding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid_id",unique = true,updatable = false)
    private Integer bidId;

    @Column(name = "artwork_id",nullable = false,length = 100)
    private Integer artworkId;

    @Column(name = "user_id",nullable = false,length = 100)
    private Integer userId;

    @Column(name = "bid_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal bidAmount;

    @CreationTimestamp
    @Column(name = "bid_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date bidDate;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private table_users user;

    @ManyToOne
    @JoinColumn(name = "artwork_id", insertable = false, updatable = false)
    private table_artworks artworks;

}
