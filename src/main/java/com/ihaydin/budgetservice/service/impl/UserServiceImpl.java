package com.ihaydin.budgetservice.service.impl;

import com.ihaydin.budgetservice.dto.UserDto;
import com.ihaydin.budgetservice.mappers.UserMapper;
import com.ihaydin.budgetservice.mappers.impl.UserMapperImpl;
import com.ihaydin.budgetservice.model.User;
import com.ihaydin.budgetservice.repository.UserRepository;
import com.ihaydin.budgetservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    private static UserMapper userMapper = UserMapperImpl.getInstance();

    @Override
    public List<UserDto> findAll() {
        List<User> userList = userRepository.findAll();
        return userMapper.toListDto(userList);
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return userMapper.toOptionalDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User saved = userRepository.save(user);
        return userMapper.toDto(saved);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User updated = userRepository.save(user);
        return userMapper.toDto(updated);
    }

    @Override
    public Boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
