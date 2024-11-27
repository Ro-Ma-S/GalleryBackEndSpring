package com.example.artSellingProject_postgresql.table_model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "artworks_table")
@Entity
public class table_artworks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artwork_id", unique = true, updatable = false)
    private Integer artworkId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "category", nullable = true, length = 100)
    private String category;

    @Column(name = "style", nullable = true, length = 100)
    private String style;

    @Column(name = "creation_date", nullable = true)
    private String creationDate;  // Changed to LocalDate for better date handling

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "dimensions", nullable = true, length = 100)
    private String dimensions;

    @Column(name = "medium", nullable = true, length = 100)
    private String medium;

    @Column(name = "image_url", nullable = true, length = 255)
    private String imageUrl;  // Renamed to follow camelCase convention

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
//
//    @UpdateTimestamp
//    @Column(name = "updated_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date updated_at;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private table_users artist;  // Assuming a corresponding TableUsers class exists
}
