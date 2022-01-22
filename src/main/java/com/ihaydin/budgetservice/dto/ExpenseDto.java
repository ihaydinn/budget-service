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
public class ExpenseDto {
    private Long id;

    private String category;
    private String bankName;
    private String description;
    private String price;
    private long date;
}
