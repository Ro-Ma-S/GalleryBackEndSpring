package com.example.artSellingProject_postgresql._1controller;

import com.example.artSellingProject_postgresql._2service.service_users;
import com.example.artSellingProject_postgresql.table_model.table_users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users_ArtProj")
public class controller_users {
    @Autowired
    private service_users usersService;

    @GetMapping("/allUsers")
    public List<table_users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/userId/{user_id}")
    public Optional<table_users> getUserById(@PathVariable Integer user_id) {
        return usersService.getUserById(user_id);
    }

    @GetMapping("/category/{category}")
    public List<table_users> getUsersByCategory(@PathVariable String category) {
        return usersService.getUsersByCategory(category);
    }

    @GetMapping("/gender/{gender}")
    public List<table_users> getUsersByGender(@PathVariable String gender) {
        return usersService.getUsersByGender(gender);
    }

    @PostMapping("/add")
    public String addUser(@RequestBody table_users user) {
        return usersService.addUser(user);
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody table_users user) {
        return usersService.updateUser(user);
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestBody table_users user)  {
        return usersService.deleteUser(user);
    }
}
