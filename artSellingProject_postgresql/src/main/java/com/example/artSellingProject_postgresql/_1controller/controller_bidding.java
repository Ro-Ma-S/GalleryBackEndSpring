package com.example.artSellingProject_postgresql._1controller;

import com.example.artSellingProject_postgresql._2service.service_bidding;
import com.example.artSellingProject_postgresql.table_model.table_bidding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bidding_ArtProj")
public class controller_bidding {

    @Autowired
    private service_bidding biddingService;

    @GetMapping("/allBiddings")
    public List<table_bidding> getAllBiddings() {
        return biddingService.getAllBiddings();
    }

    // Get bidding by bid ID
    @GetMapping("/bid/{bid_id}")
    public Optional<table_bidding> getBiddingById(@PathVariable("bid_id") Integer bidId) {
        return biddingService.getBiddingById(bidId);
    }

    // Get biddings by user ID
    @GetMapping("/user/{user_id}")
    public List<table_bidding> getBiddingByUserId(@PathVariable("user_id") Integer userId) {
        return biddingService.getBiddingByUserId(userId);
    }

    // Get biddings by artwork ID
    @GetMapping("/artwork/{artwork_id}")
    public List<table_bidding> getBiddingByArtworkId(@PathVariable("artwork_id") Integer artworkId) {
        return biddingService.getBiddingByArtworkId(artworkId);
    }

    @PostMapping({"/add"})
    public String addBidding(@RequestBody table_bidding bidding)
    {
        return biddingService.addBidding(bidding);
    }
    @PutMapping({"update"})
    public String updateBidding(@RequestBody table_bidding bidding)
    {
        return biddingService.updateBidding(bidding);
    }
    @DeleteMapping ({"delete"})
    public String deleteBidding(@RequestBody table_bidding bidding)
    {
        return biddingService.deleteBidding(bidding);
    }
}
