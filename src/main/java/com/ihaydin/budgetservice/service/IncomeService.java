package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.model.Income;

import java.util.List;
import java.util.Optional;

public interface IncomeService {
    List<Income> findAll();
    Optional<Income> findById(Long id);
    Income createIncome(Income income);
    Income updateIncome(Income income);
    Boolean deleteIncome(Long id);
}
