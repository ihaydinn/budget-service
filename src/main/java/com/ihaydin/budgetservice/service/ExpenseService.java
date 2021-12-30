package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.model.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {
    List<Expense> findAll();
    Optional<Expense> findById(Long id);

}
