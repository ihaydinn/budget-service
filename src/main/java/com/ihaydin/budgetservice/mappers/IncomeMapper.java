package com.ihaydin.budgetservice.mappers;

import com.ihaydin.budgetservice.dto.IncomeDto;
import com.ihaydin.budgetservice.model.Income;

import java.util.List;
import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 22, January, 2022
 */
public interface IncomeMapper {
    Income toEntity(IncomeDto incomeDto);
    IncomeDto toDto(Income income);
    List<IncomeDto> toListDto(List<Income> incomeList);
    Optional<IncomeDto> toOptionalDto(Optional<Income> optionalIncome);
}
