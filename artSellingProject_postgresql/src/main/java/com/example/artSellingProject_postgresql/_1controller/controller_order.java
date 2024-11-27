package com.example.artSellingProject_postgresql._1controller;

import com.example.artSellingProject_postgresql._2service.service_order;
import com.example.artSellingProject_postgresql.table_model.table_order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("orders_ArtProj")
public class controller_order {

    @Autowired
    private service_order ordersService;

    @GetMapping("/allOrders")
    public List<table_order> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/orderId/{order_id}")
    public Optional<table_order> getOrderById(@PathVariable Integer order_id) {
        return ordersService.getOrderById(order_id);
    }

    @GetMapping("/userId/{user_id}")
    public List<table_order> getOrdersByUserId(@PathVariable Integer user_id) {
        return ordersService.getOrdersByUserId(user_id);
    }

    @GetMapping("/artworkId/{artwork_id}")
    public List<table_order> getOrdersByArtworkId(@PathVariable Integer artwork_id) {
        return ordersService.getOrdersByArtworkId(artwork_id);
    }

    @GetMapping("/orderStatus/{status}")
    public List<table_order> getOrdersByStatus(@PathVariable String status) {
        return ordersService.getOrdersByStatus(status);
    }


    @PostMapping("/add")
    public String addOrder(@RequestBody table_order order) {
        return ordersService.addOrder(order);
    }

    @PutMapping("/update")
    public String updateOrder(@RequestBody table_order order) {
        return ordersService.updateOrder(order);
    }

    @DeleteMapping("/delete")
    public String deleteOrder(@RequestBody table_order order) {
        return ordersService.deleteOrder(order);
    }
}
