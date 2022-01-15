package com.ihaydin.budgetservice.service.impl;

import com.ihaydin.budgetservice.model.Income;
import com.ihaydin.budgetservice.repository.IncomeRepository;
import com.ihaydin.budgetservice.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    IncomeRepository incomeRepository;

    @Override
    public List<Income> findAll() {
        return incomeRepository.findAll();
    }

    @Override
    public Optional<Income> findById(UUID uuid) {
        return incomeRepository.findById(uuid);
    }

    @Override
    public Income createIncome(Income income) {
        return incomeRepository.save(income);
    }

    @Override
    public Income updateIncome(Income income) {
        return incomeRepository.save(income);
    }

    @Override
    public Boolean deleteIncome(UUID uuid) {
        incomeRepository.deleteById(uuid);
        return true;
    }
}
