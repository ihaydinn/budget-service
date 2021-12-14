package com.ihaydin.budgetservice.service;


import com.ihaydin.budgetservice.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(UUID uuid);
    User createUser(User user);
    User updateUser(User user);
    Boolean deleteUser(UUID uuid);
}
