package com.ihaydin.budgetservice.service.impl;

import com.ihaydin.budgetservice.dto.IncomeDto;
import com.ihaydin.budgetservice.mappers.IncomeMapper;
import com.ihaydin.budgetservice.mappers.impl.IncomeMapperImpl;
import com.ihaydin.budgetservice.model.Income;
import com.ihaydin.budgetservice.repository.IncomeRepository;
import com.ihaydin.budgetservice.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    IncomeRepository incomeRepository;

    private static IncomeMapper incomeMapper = IncomeMapperImpl.getInstance();

    @Override
    public List<IncomeDto> findAll() {
        List<Income> incomeList = incomeRepository.findAll();
        return incomeMapper.toListDto(incomeList);
    }

    @Override
    public Optional<IncomeDto> findById(Long id) {
        Optional<Income> income = incomeRepository.findById(id);
        return incomeMapper.toOptionalDto(income);
    }

    @Override
    public IncomeDto createIncome(IncomeDto incomeDto) {
        Income income = incomeMapper.toEntity(incomeDto);
        Income saved = incomeRepository.save(income);
        return incomeMapper.toDto(saved);
    }

    @Override
    public IncomeDto updateIncome(IncomeDto incomeDto) {
        Income income = incomeMapper.toEntity(incomeDto);
        Income updated = incomeRepository.save(income);
        return incomeMapper.toDto(updated);
    }

    @Override
    public Boolean deleteIncome(Long id) {
        incomeRepository.deleteById(id);
        return true;
    }
}
