package com.ihaydin.budgetservice.dto;

import com.ihaydin.budgetservice.model.Saving;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ismailhakkiaydin
 * @date 19, January, 2022
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BudgetDto {

    private Long id;

    private String category;

    private String targetValue;

    private Long time;

    private boolean isActive;

    private List<Saving> savings;

}
