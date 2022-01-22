package com.ihaydin.budgetservice.mappers.impl;

import com.ihaydin.budgetservice.dto.IncomeDto;
import com.ihaydin.budgetservice.mappers.IncomeMapper;
import com.ihaydin.budgetservice.model.Income;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 22, January, 2022
 */

public final class IncomeMapperImpl implements IncomeMapper {

    private static IncomeMapperImpl instance = new IncomeMapperImpl();

    public static IncomeMapperImpl getInstance() {
        return instance;
    }

    private IncomeMapperImpl() {
    }

    @Override
    public Income toEntity(final IncomeDto incomeDto) {
        Income income = new Income();
        income.setId(incomeDto.getId());
        income.setBankName(incomeDto.getBankName());
        income.setCategory(incomeDto.getCategory());
        income.setPrice(incomeDto.getPrice());
        income.setDescription(incomeDto.getDescription());
        income.setDate(incomeDto.getDate());
        return income;
    }

    @Override
    public IncomeDto toDto(final Income income) {
        IncomeDto incomeDto = new IncomeDto();
        incomeDto.setId(incomeDto.getId());
        incomeDto.setPrice(income.getPrice());
        incomeDto.setDate(income.getDate());
        incomeDto.setDescription(income.getDescription());
        incomeDto.setBankName(income.getBankName());
        incomeDto.setCategory(income.getCategory());
        return incomeDto;
    }

    @Override
    public List<IncomeDto> toListDto(List<Income> incomeList) {
        List<IncomeDto> incomeDtoList = new ArrayList<>(incomeList.size());
        for (Income income : incomeList) {
            incomeDtoList.add(this.toDto(income));
        }
        return incomeDtoList;
    }

    @Override
    public Optional<IncomeDto> toOptionalDto(Optional<Income> optionalIncome) {
        Income income = optionalIncome.get();
        return Optional.of(this.toDto(income));
    }
}
