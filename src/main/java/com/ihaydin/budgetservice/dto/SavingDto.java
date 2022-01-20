package com.ihaydin.budgetservice.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ismailhakkiaydin
 * @date 19, January, 2022
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavingDto {

    private Long id;

    private String amount;
}
