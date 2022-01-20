package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.dto.BudgetDto;
import com.ihaydin.budgetservice.model.Budget;

import java.util.List;
import java.util.Optional;

public interface BudgetService {
    List<BudgetDto> findAll();
    Optional<Budget> findById(Long id);
    BudgetDto createBudget(BudgetDto budgetDto);
    Budget updateBudget(Budget budget);
    Boolean deleteBudget(Long id);
}
