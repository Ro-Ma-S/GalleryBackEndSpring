package com.example.artSellingProject_postgresql.table_model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Table(name="messages_review_table")
@Entity
public class table_msgReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id",unique = true,updatable = false)
    private Integer reviewId;

    @Column(name = "artwork_id",nullable = false,length = 100)
    private Integer artworkId;

    @Column(name = "user_id",nullable = false,length = 100)
    private Integer userId;

    @Column(name="rating",nullable = true,length = 100)
    private Integer rating;

    @Column(name = "review_text", columnDefinition = "TEXT")
    private String reviewText;


    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

//    @UpdateTimestamp
//    @Column(name = "updated_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private table_users user;

    @ManyToOne
    @JoinColumn(name = "artwork_id", insertable = false, updatable = false)
    private table_artworks artworks;
}
