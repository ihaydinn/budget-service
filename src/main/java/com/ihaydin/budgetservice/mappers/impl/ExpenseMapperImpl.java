package com.ihaydin.budgetservice.mappers.impl;

import com.ihaydin.budgetservice.dto.ExpenseDto;
import com.ihaydin.budgetservice.mappers.ExpenseMapper;
import com.ihaydin.budgetservice.model.Expense;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 22, January, 2022
 */

public final class ExpenseMapperImpl implements ExpenseMapper {

    private static ExpenseMapperImpl instance = new ExpenseMapperImpl();

    public static ExpenseMapperImpl getInstance() {
        return instance;
    }

    private ExpenseMapperImpl() {

    }


    @Override
    public Expense toEntity(final ExpenseDto expenseDto) {
        Expense expense = new Expense();
        expense.setId(expenseDto.getId());
        expense.setDate(expenseDto.getDate());
        expense.setCategory(expenseDto.getCategory());
        expense.setDescription(expenseDto.getDescription());
        expense.setPrice(expenseDto.getPrice());
        expense.setBankName(expenseDto.getBankName());
        return expense;
    }

    @Override
    public ExpenseDto toDto(final Expense expense) {
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setId(expense.getId());
        expenseDto.setBankName(expense.getBankName());
        expenseDto.setDate(expense.getDate());
        expenseDto.setCategory(expense.getCategory());
        expenseDto.setDescription(expense.getDescription());
        expenseDto.setPrice(expense.getPrice());
        return expenseDto;
    }

    @Override
    public List<ExpenseDto> toListDto(List<Expense> expenseList) {
        List<ExpenseDto> expenseDtoList = new ArrayList<>(expenseList.size());
        for (Expense expense : expenseList) {
            expenseDtoList.add(this.toDto(expense));
        }
        return expenseDtoList;
    }

    @Override
    public Optional<ExpenseDto> toOptionalDto(Optional<Expense> optionalExpense) {
        Expense expense = optionalExpense.get();
        return Optional.of(this.toDto(expense));
    }
}
