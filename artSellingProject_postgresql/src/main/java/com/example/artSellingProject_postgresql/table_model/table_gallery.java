package com.example.artSellingProject_postgresql.table_model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Table(name="gallery_table")
@Entity
public class table_gallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gallery_id",unique = true,updatable = false)
    private Integer galleryId;

    @Column(name = "name",nullable = false,length = 255)
    private String Name;

    @Column(name = "location",nullable = false,length = 255)
    private String Location;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

//    @Column(name = "artwork_ids", columnDefinition = "TEXT")
//    private String artworkIds;

    @Column(name = "user_id",nullable = false)
    private Integer userId;

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
    private table_users organiser;
}
