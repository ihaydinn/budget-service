package com.ihaydin.budgetservice.api;


import com.ihaydin.budgetservice.model.User;
import com.ihaydin.budgetservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/")
public class BudgetRestService {

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

}
