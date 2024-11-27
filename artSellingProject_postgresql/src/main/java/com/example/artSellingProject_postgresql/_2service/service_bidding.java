package com.example.artSellingProject_postgresql._2service;

import com.example.artSellingProject_postgresql._3repository_dao.dao_bidding;
import com.example.artSellingProject_postgresql.table_model.table_bidding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class service_bidding {

    @Autowired
    private dao_bidding biddingDao;

    public List<table_bidding> getAllBiddings() {
        return biddingDao.findAll();
    }

    public Optional<table_bidding> getBiddingById(Integer bidId) {
        return biddingDao.findById(bidId);
    }

    public List<table_bidding> getBiddingByUserId(Integer userId) {
        return biddingDao.findByUserId(userId);
    }

    public List<table_bidding> getBiddingByArtworkId(Integer artworkId) {
        return biddingDao.findByArtworkId(artworkId);
    }

    public String addBidding(table_bidding bidding) {
        biddingDao.save(bidding);
        return "Inserted Successfully into bidding_table";
    }

    public String updateBidding(table_bidding bidding) {
        if(biddingDao.existsById(bidding.getBidId())){
            biddingDao.save(bidding);
            return "Artwork updated Successfully";
        }
        else {
            return "Artwork not found";
        }
    }

    public String deleteBidding(table_bidding bidding) {
        if(biddingDao.existsById(bidding.getBidId())){
            biddingDao.save(bidding);
            return "Artwork Deleted Successfully";
        }
        else {
            return "Artwork not found";
        }
    }
}
