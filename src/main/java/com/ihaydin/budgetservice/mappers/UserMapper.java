package com.ihaydin.budgetservice.mappers;

import com.ihaydin.budgetservice.dto.UserDto;
import com.ihaydin.budgetservice.model.User;

import java.util.List;
import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 22, January, 2022
 */
public interface UserMapper {
    User toEntity(UserDto userDto);
    UserDto toDto(User user);
    List<UserDto> toListDto(List<User> userList);
    Optional<UserDto> toOptionalDto(Optional<User> optionalUser);
}
