package com.ihaydin.budgetservice.service;


import com.ihaydin.budgetservice.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User createUser(User user);
}
