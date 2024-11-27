package com.example.artSellingProject_postgresql._2service;

import com.example.artSellingProject_postgresql._3repository_dao.dao_msgReview;
import com.example.artSellingProject_postgresql.table_model.table_msgReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class service_msgReview {

    @Autowired
    private dao_msgReview reviewRepository;

    public List<table_msgReview> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<table_msgReview> getReviewById(Integer reviewId) {
        return reviewRepository.findById(reviewId);
    }

    public List<table_msgReview> getReviewsByUserId(Integer userId) {
        return reviewRepository.findByUserId(userId);
    }

    public List<table_msgReview> getReviewsByArtworkId(Integer artworkId) {
        return reviewRepository.findByArtworkId(artworkId);
    }

    public List<table_msgReview> getReviewsByRating(Integer rating) {
        return reviewRepository.findByRating(rating);
    }

    public String addReview(table_msgReview review) {
        reviewRepository.save(review);
        return "Review added Successfully";
    }

    public String updateReview(table_msgReview review) {
        if(reviewRepository.existsById(review.getReviewId()))
        {
            reviewRepository.save(review);
            return "Review Updated Successfully";
        }
        else {
            return "Review not found";
        }
    }

    public String deleteReview(table_msgReview review) {
        if(reviewRepository.existsById(review.getReviewId()))
        {
            reviewRepository.save(review);
            return "Review Deleted Successfully";
        }
        else {
            return "Review not found";
        }
    }
}
