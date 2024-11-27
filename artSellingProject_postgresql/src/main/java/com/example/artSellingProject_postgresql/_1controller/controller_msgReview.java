package com.example.artSellingProject_postgresql._1controller;

import com.example.artSellingProject_postgresql._2service.service_msgReview;
import com.example.artSellingProject_postgresql.table_model.table_msgReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/msgReview_ArtProj")
public class controller_msgReview {

    @Autowired
    private service_msgReview reviewService;

    @GetMapping("/allReviews")
    public List<table_msgReview> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/reviewId/{review_id}")
    public Optional<table_msgReview> getReviewById(@PathVariable Integer review_id) {
        return reviewService.getReviewById(review_id);
    }

    @GetMapping("/userId/{user_id}")
    public List<table_msgReview> getReviewsByUserId(@PathVariable Integer user_id) {
        return reviewService.getReviewsByUserId(user_id);
    }

    @GetMapping("/artworkId/{artwork_id}")
    public List<table_msgReview> getReviewsByArtworkId(@PathVariable Integer artwork_id) {
        return reviewService.getReviewsByArtworkId(artwork_id);
    }

    @GetMapping("/rating/{rating}")
    public List<table_msgReview> getReviewsByRating(@PathVariable Integer rating) {
        return reviewService.getReviewsByRating(rating);
    }
    @PostMapping("/add")
    public String addReview(@RequestBody table_msgReview review) {
        return reviewService.addReview(review);
    }

    @PutMapping("/update")
    public String updateReview(@RequestBody table_msgReview review) {
        return reviewService.updateReview(review);
    }

    @DeleteMapping("/delete")
    public String deleteReview(@RequestBody table_msgReview review) {
        return reviewService.deleteReview(review);
    }
}
