package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.model.Budget;
import com.ihaydin.budgetservice.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetServiceImpl implements BudgetService{

    @Autowired
    private BudgetRepository budgetRepository;

    @Override
    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }

    @Override
    public Optional<Budget> findById(Long id) {
        return budgetRepository.findById(id);
    }
}
