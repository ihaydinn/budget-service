package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.dto.BankDto;

import java.util.List;
import java.util.Optional;

public interface BankService {
    List<BankDto> findAll();
    Optional<BankDto> findById(Long id);
    BankDto createBank(BankDto bankDto);
    BankDto updateBank(BankDto bankDto);
    boolean deleteBank(Long id);
}
