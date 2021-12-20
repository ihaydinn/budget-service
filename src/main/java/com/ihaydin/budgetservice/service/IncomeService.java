package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.model.Income;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IncomeService {
    List<Income> findAll();
    Optional<Income> findById(UUID uuid);
    Income createIncome(Income income);
    Income updateIncome(Income income);
    Boolean deleteIncome(UUID uuid);
}
