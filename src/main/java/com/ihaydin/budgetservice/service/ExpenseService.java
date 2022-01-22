package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.dto.ExpenseDto;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {
    List<ExpenseDto> findAll();
    Optional<ExpenseDto> findById(Long id);
    ExpenseDto createExpense(ExpenseDto expenseDto);
    ExpenseDto updateExpense(ExpenseDto expenseDto);
    Boolean deleteExpense(Long id);

}
