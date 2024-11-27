package com.example.artSellingProject_postgresql._2service;


import com.example.artSellingProject_postgresql._3repository_dao.dao_users;
import com.example.artSellingProject_postgresql.table_model.table_users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class service_users {

    @Autowired
    private dao_users usersRepository;
    public List<table_users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Optional<table_users> getUserById(Integer userId) {
        return usersRepository.findById(userId);
    }

    public List<table_users> getUsersByCategory(String category) {
        return usersRepository.findByCategory(category);
    }

    public List<table_users> getUsersByGender(String gender) {
        return usersRepository.findByGender(gender);
    }

    public String addUser(table_users user) {
        usersRepository.save(user);
        return "User added successfully!";
    }

    public String updateUser(table_users user) {
        if (usersRepository.existsById(user.getUserId())) {
            usersRepository.save(user);
            return "User updated successfully!";
        } else {
            return "User not found!";
        }
    }

    public String deleteUser(table_users user) {
        if (usersRepository.existsById(user.getUserId())) {
            usersRepository.save(user);
            return "User Deleted successfully!";
        } else {
            return "User not found!";
        }
    }
}
