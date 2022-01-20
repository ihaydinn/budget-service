package com.ihaydin.budgetservice.mappers;

import com.ihaydin.budgetservice.dto.BudgetDto;
import com.ihaydin.budgetservice.model.Budget;

import java.util.List;

/**
 * @author ismailhakkiaydin
 * @date 19, January, 2022
 */

public interface BudgetMapper {
    Budget toEntity(BudgetDto budgetDto);
    BudgetDto toDto(Budget budget);
    List<BudgetDto> toListDto(List<Budget> budgetList);
}
