package com.example.artSellingProject_postgresql.table_model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Table(name="events_table")
@Entity
public class table_events {

     /*
    CREATE TABLE Events (
    event_id INT AUTO_INCREMENT PRIMARY KEY,
    event_name VARCHAR(255) NOT NULL,
    description TEXT,
    organiser_id INT NOT NULL,
    event_start_date DATE,
    event_end_date DATE,
    location VARCHAR(255),
    registration_form_link VARCHAR(255),
    link_end_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (organiser_id) REFERENCES Users(user_id)
            );

      */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id",unique = true,updatable = false)
    private Integer eventId;

    @Column(name = "event_name",nullable = false,length = 255)
    private String eventName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "user_id",nullable = false)
    private Integer userId;

    @Column(name = "event_start_date")
    private Date eventStartDate;

    @Column(name = "event_end_date")
    private Date eventEndDate;

    @Column(name = "location",nullable = true,length = 255)
    private String location;

    @Column(name = "registration_form_link")
    private String formLink;

    @Column(name = "link_end_date")
    private Date formLinkEndDate;

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
