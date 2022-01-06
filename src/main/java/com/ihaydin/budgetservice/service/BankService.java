package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.model.Bank;

import java.util.List;
import java.util.Optional;

public interface BankService {
    List<Bank> findAll();
    Optional<Bank> findById(Long id);

}
