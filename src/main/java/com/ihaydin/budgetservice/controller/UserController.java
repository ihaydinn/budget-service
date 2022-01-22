package com.ihaydin.budgetservice.controller;


import com.ihaydin.budgetservice.dto.UserDto;
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
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> viewList = service.findAll();
        return ResponseEntity.ok(viewList);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getSingleSaving(@PathVariable Long id) {
        Optional<UserDto> userDtoId = service.findById(id);
        UserDto userDtoBody = null;
        if (userDtoId.isPresent()) {
            userDtoBody = userDtoId.get();
        }
        return ResponseEntity.ok(userDtoBody);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto result = service.createUser(userDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        Optional<UserDto> optionalUser = service.findById(id);
        UserDto userDtoBody = optionalUser.get();

        userDtoBody.setFirstName(userDto.getFirstName());
        userDtoBody.setLastName(userDto.getLastName());
        userDtoBody.setEmail(userDto.getEmail());

        final UserDto updatedUser = service.createUser(userDtoBody);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteUser(id));
    }

}
