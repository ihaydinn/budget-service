package com.ihaydin.budgetservice.service;


import com.ihaydin.budgetservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Long id);
    User createUser(User user);
    User updateUser(User user);
    Boolean deleteUser(Long id);
}
