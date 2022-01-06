package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.model.Budget;

import java.util.List;

public interface BudgetService {
    List<Budget> findAll();
}
