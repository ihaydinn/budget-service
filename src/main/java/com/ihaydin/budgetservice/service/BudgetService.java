package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.dto.BudgetDto;

import java.util.List;
import java.util.Optional;

public interface BudgetService {
    List<BudgetDto> findAll();
    Optional<BudgetDto> findById(Long id);
    BudgetDto createBudget(BudgetDto budgetDto);
    BudgetDto updateBudget(BudgetDto budgetDto);
    Boolean deleteBudget(Long id);
}
