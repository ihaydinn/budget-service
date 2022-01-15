package com.ihaydin.budgetservice.controller;


import com.ihaydin.budgetservice.model.User;
import com.ihaydin.budgetservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("working");
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> viewList = service.findAll();
        return ResponseEntity.ok(viewList);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User result = service.createUser(user);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        Optional<User> optionalUser = service.findById(id);
        User userBody = optionalUser.get();

        userBody.setFirstName(user.getFirstName());
        userBody.setLastName(user.getLastName());
        userBody.setEmail(user.getEmail());

        final User updatedUser = service.createUser(userBody);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok(service.deleteUser(id));
    }

}