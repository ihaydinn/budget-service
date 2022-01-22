package com.ihaydin.budgetservice.mappers;

import com.ihaydin.budgetservice.dto.ExpenseDto;
import com.ihaydin.budgetservice.model.Expense;

import java.util.List;
import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 22, January, 2022
 */
public interface ExpenseMapper {
    Expense toEntity(ExpenseDto expenseDto);
    ExpenseDto toDto(Expense expense);
    List<ExpenseDto> toListDto(List<Expense> expenseList);
    Optional<ExpenseDto> toOptionalDto(Optional<Expense> optionalExpense);
}
