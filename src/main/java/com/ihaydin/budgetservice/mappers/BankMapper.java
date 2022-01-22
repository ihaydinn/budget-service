package com.ihaydin.budgetservice.mappers;

import com.ihaydin.budgetservice.dto.BankDto;
import com.ihaydin.budgetservice.model.Bank;

import java.util.List;
import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 22, January, 2022
 */
public interface BankMapper {
    Bank toEntity(BankDto bankDto);
    BankDto toDto(Bank bank);
    List<BankDto> toListDto(List<Bank> bankList);
    Optional<BankDto> toOptionalDto(Optional<Bank> optionalBank);
}
