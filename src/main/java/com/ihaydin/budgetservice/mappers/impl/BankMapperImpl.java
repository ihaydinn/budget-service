package com.ihaydin.budgetservice.mappers.impl;

import com.ihaydin.budgetservice.dto.BankDto;
import com.ihaydin.budgetservice.mappers.BankMapper;
import com.ihaydin.budgetservice.model.Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 22, January, 2022
 */

public final class BankMapperImpl implements BankMapper {

    private static BankMapperImpl instance = new BankMapperImpl();

    public static BankMapperImpl getInstance() {
        return instance;
    }

    private BankMapperImpl() {
    }

    @Override
    public Bank toEntity(BankDto bankDto) {
        Bank bank = new Bank();
        bank.setId(bankDto.getId());
        bank.setBankName(bankDto.getBankName());
        bank.setTotalAmount(bankDto.getTotalAmount());
        return bank;
    }

    @Override
    public BankDto toDto(Bank bank) {
        BankDto bankDto = new BankDto();
        bankDto.setId(bank.getId());
        bankDto.setBankName(bank.getBankName());
        bankDto.setTotalAmount(bank.getTotalAmount());
        return bankDto;
    }

    @Override
    public List<BankDto> toListDto(List<Bank> bankList) {
        List<BankDto> bankDtoList = new ArrayList<>(bankList.size());
        for (Bank bank : bankList) {
            bankDtoList.add(this.toDto(bank));
        }
        return bankDtoList;
    }

    @Override
    public Optional<BankDto> toOptionalDto(Optional<Bank> optionalBank) {
        Bank bank = optionalBank.get();
        return Optional.of(this.toDto(bank));
    }
}
