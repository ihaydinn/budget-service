package com.ihaydin.budgetservice.service.impl;

import com.ihaydin.budgetservice.dto.BudgetDto;
import com.ihaydin.budgetservice.mappers.BudgetMapper;
import com.ihaydin.budgetservice.mappers.impl.BudgetMapperImpl;
import com.ihaydin.budgetservice.model.Budget;
import com.ihaydin.budgetservice.repository.BudgetRepository;
import com.ihaydin.budgetservice.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    private static BudgetMapper budgetMapper = BudgetMapperImpl.getInstance();

    @Override
    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }

    @Override
    public Optional<Budget> findById(Long id) {
        return budgetRepository.findById(id);
    }

    @Override
    public BudgetDto createBudget(BudgetDto budgetDto) {
        Budget budget = budgetMapper.toEntity(budgetDto);
        Budget saved = budgetRepository.save(budget);

        return budgetMapper.toDto(saved);
    }

    @Override
    public Budget updateBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    @Override
    public Boolean deleteBudget(Long id) {
        budgetRepository.deleteById(id);
        return true;
    }
}
