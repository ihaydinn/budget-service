package com.ihaydin.budgetservice.service;


import com.ihaydin.budgetservice.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> findAll();
    Optional<UserDto> findById(Long id);
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    Boolean deleteUser(Long id);
}
