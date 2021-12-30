package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.model.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> findAll();

}
