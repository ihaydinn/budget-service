package com.ihaydin.budgetservice.mappers.impl;

import com.ihaydin.budgetservice.dto.BudgetDto;
import com.ihaydin.budgetservice.mappers.BudgetMapper;
import com.ihaydin.budgetservice.model.Budget;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ismailhakkiaydin
 * @date 19, January, 2022
 */

public final class BudgetMapperImpl implements BudgetMapper {

    public static BudgetMapperImpl instance = new BudgetMapperImpl();

    private BudgetMapperImpl() {
    }

    public static BudgetMapperImpl getInstance() {
        return instance;
    }

    @Override
    public Budget toEntity(final BudgetDto budgetDto) {
        Budget budget = new Budget();
        budget.setId(budgetDto.getId());
        budget.setCategory(budgetDto.getCategory());
        budget.setTargetValue(budgetDto.getTargetValue());
        budget.setTime(budgetDto.getTime());
        budget.setActive(budgetDto.isActive());
        return budget;
    }

    @Override
    public BudgetDto toDto(final Budget budget) {
        BudgetDto budgetDto = new BudgetDto();
        budgetDto.setId(budget.getId());
        budgetDto.setCategory(budget.getCategory());
        budgetDto.setTargetValue(budget.getTargetValue());
        budgetDto.setTime(budget.getTime());
        budgetDto.setActive(budget.isActive());
        return budgetDto;
    }

    @Override
    public List<BudgetDto> toListDto(List<Budget> budgetList) {
        List<BudgetDto> budgetDtoList = new ArrayList<>(budgetList.size());
        for (Budget budget : budgetList) {
            budgetDtoList.add(this.toDto(budget));
        }
        return budgetDtoList;
    }
}
