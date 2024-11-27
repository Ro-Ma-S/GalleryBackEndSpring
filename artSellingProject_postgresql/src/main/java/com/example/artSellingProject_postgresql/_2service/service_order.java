package com.example.artSellingProject_postgresql._2service;

import com.example.artSellingProject_postgresql._3repository_dao.dao_order;
import com.example.artSellingProject_postgresql.table_model.table_order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class service_order {

    @Autowired
    private dao_order ordersDao;
    public List<table_order> getAllOrders() {
        return ordersDao.findAll();
    }

    public Optional<table_order> getOrderById(Integer orderId) {
        return ordersDao.findById(orderId);
    }

    public List<table_order> getOrdersByUserId(Integer userId) {
        return ordersDao.findByUserId(userId);
    }

    public List<table_order> getOrdersByArtworkId(Integer artworkId) {
        return ordersDao.findByArtworkId(artworkId);
    }

    public List<table_order> getOrdersByStatus(String status) {
        return ordersDao.findByStatus(status);
    }

    public String addOrder(table_order order) {
        ordersDao.save(order);
        return "Order placed Successfully";
    }

    public String updateOrder(table_order order) {
        if(ordersDao.existsById(order.getOrderId())){
            ordersDao.save(order);
            return "Order updated Successfully";
        }
        else {
            return "Order not found";
        }
    }

    public String deleteOrder(table_order order) {
        if(ordersDao.existsById(order.getOrderId())){
            ordersDao.save(order);
            return "Order deleted Successfully";
        }
        else {
            return "Order not found";
        }
    }
}
