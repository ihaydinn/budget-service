package com.ihaydin.budgetservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ismailhakkiaydin
 * @date 22, January, 2022
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    private String firstName;
    private String lastName;
    private int age;
    private String userName;
    private String phoneNumber;
    private String email;
}
