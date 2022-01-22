package com.ihaydin.budgetservice.mappers.impl;

import com.ihaydin.budgetservice.dto.UserDto;
import com.ihaydin.budgetservice.mappers.UserMapper;
import com.ihaydin.budgetservice.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 22, January, 2022
 */

public final class UserMapperImpl implements UserMapper {

    private static UserMapperImpl instance = new UserMapperImpl();

    public static UserMapperImpl getInstance() {
        return instance;
    }

    private UserMapperImpl() {
    }

    @Override
    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setLastName(userDto.getLastName());
        user.setFirstName(userDto.getFirstName());
        user.setUserName(userDto.getUserName());
        user.setAge(userDto.getAge());
        user.setPhoneNumber(userDto.getPhoneNumber());
        return user;
    }

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setAge(user.getAge());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPhoneNumber(user.getPhoneNumber());
        return userDto;
    }

    @Override
    public List<UserDto> toListDto(List<User> userList) {
        List<UserDto> userDtoList = new ArrayList<>(userList.size());
        for (User user : userList) {
            userDtoList.add(this.toDto(user));
        }
        return userDtoList;
    }

    @Override
    public Optional<UserDto> toOptionalDto(Optional<User> optionalUser) {
        User user = optionalUser.get();
        return Optional.of(this.toDto(user));
    }
}
