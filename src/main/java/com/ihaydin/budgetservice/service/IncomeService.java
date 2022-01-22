package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.dto.IncomeDto;

import java.util.List;
import java.util.Optional;

public interface IncomeService {
    List<IncomeDto> findAll();
    Optional<IncomeDto> findById(Long id);
    IncomeDto createIncome(IncomeDto incomeDto);
    IncomeDto updateIncome(IncomeDto incomeDto);
    Boolean deleteIncome(Long id);
}
