package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.model.Income;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IncomeServiceImpl implements IncomeService {


    @Override
    public List<Income> findAll() {
        return null;
    }

    @Override
    public Optional<Income> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Income createIncome(Income income) {
        return null;
    }

    @Override
    public Income updateIncome(Income income) {
        return null;
    }

    @Override
    public Boolean deleteIncome(UUID uuid) {
        return null;
    }
}
