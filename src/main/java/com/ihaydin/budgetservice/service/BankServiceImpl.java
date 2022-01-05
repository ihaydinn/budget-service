package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.model.Bank;
import com.ihaydin.budgetservice.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;


    @Override
    public List<Bank> findAll() {
        return bankRepository.findAll();
    }
}
