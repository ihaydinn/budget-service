package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.model.Bank;
import com.ihaydin.budgetservice.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;


    @Override
    public List<Bank> findAll() {
        return bankRepository.findAll();
    }

    @Override
    public Optional<Bank> findById(Long id) {
        return bankRepository.findById(id);
    }

    @Override
    public Bank createBank(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public Bank updateBank(Bank bank) {
        return bankRepository.save(bank);
    }
}
