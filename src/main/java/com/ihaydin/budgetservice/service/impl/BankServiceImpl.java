package com.ihaydin.budgetservice.service.impl;

import com.ihaydin.budgetservice.dto.BankDto;
import com.ihaydin.budgetservice.mappers.BankMapper;
import com.ihaydin.budgetservice.mappers.impl.BankMapperImpl;
import com.ihaydin.budgetservice.model.Bank;
import com.ihaydin.budgetservice.repository.BankRepository;
import com.ihaydin.budgetservice.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    private static BankMapper bankMapper = BankMapperImpl.getInstance();

    @Override
    public List<BankDto> findAll() {
        List<Bank> bankDtoList = bankRepository.findAll();
        return bankMapper.toListDto(bankDtoList);
    }

    @Override
    public Optional<BankDto> findById(Long id) {
        Optional<Bank> bank = bankRepository.findById(id);
        return bankMapper.toOptionalDto(bank);
    }

    @Override
    public BankDto createBank(BankDto bankDto) {
        Bank bank = bankMapper.toEntity(bankDto);
        Bank saved = bankRepository.save(bank);
        return bankMapper.toDto(saved);
    }

    @Override
    public BankDto updateBank(BankDto bankDto) {
        Bank bank = bankMapper.toEntity(bankDto);
        Bank updated = bankRepository.save(bank);
        return bankMapper.toDto(updated);
    }

    @Override
    public boolean deleteBank(Long id) {
        bankRepository.deleteById(id);
        return true;
    }
}
