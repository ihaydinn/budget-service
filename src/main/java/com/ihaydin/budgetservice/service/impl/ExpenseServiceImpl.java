package com.ihaydin.budgetservice.service.impl;

import com.ihaydin.budgetservice.dto.ExpenseDto;
import com.ihaydin.budgetservice.mappers.ExpenseMapper;
import com.ihaydin.budgetservice.mappers.impl.ExpenseMapperImpl;
import com.ihaydin.budgetservice.model.Expense;
import com.ihaydin.budgetservice.repository.ExpenseRepository;
import com.ihaydin.budgetservice.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    private static ExpenseMapper expenseMapper = ExpenseMapperImpl.getInstance();

    @Override
    public List<ExpenseDto> findAll() {
        List<Expense> expenseDtoList = expenseRepository.findAll();
        return expenseMapper.toListDto(expenseDtoList);
    }

    @Override
    public Optional<ExpenseDto> findById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        return expenseMapper.toOptionalDto(expense);
    }

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = expenseMapper.toEntity(expenseDto);
        Expense saved = expenseRepository.save(expense);
        return expenseMapper.toDto(saved);
    }

    @Override
    public ExpenseDto updateExpense(ExpenseDto expenseDto) {
        Expense expense = expenseMapper.toEntity(expenseDto);
        Expense updated = expenseRepository.save(expense);
        return expenseMapper.toDto(updated);
    }

    @Override
    public Boolean deleteExpense(Long id) {
        expenseRepository.deleteById(id);
        return true;
    }

}
