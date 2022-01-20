package com.ihaydin.budgetservice.service.impl;

import com.ihaydin.budgetservice.dto.SavingDto;
import com.ihaydin.budgetservice.mappers.SavingMapper;
import com.ihaydin.budgetservice.mappers.impl.SavingMapperImpl;
import com.ihaydin.budgetservice.model.Budget;
import com.ihaydin.budgetservice.model.Saving;
import com.ihaydin.budgetservice.repository.SavingRepository;
import com.ihaydin.budgetservice.service.SavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 08, January, 2022
 */

@Service
public class SavingServiceImpl implements SavingService {

    @Autowired
    SavingRepository savingRepository;

    private static SavingMapper savingMapper = SavingMapperImpl.getInstance();

    @Override
    public List<Saving> findAll() {
        return savingRepository.findAll();
    }

    @Override
    public Optional<Saving> findById(Long id) {
        return savingRepository.findById(id);
    }

    @Override
    public SavingDto createSaving(SavingDto savingDto) {
        Saving saving = savingMapper.toEntity(savingDto);
        Saving saved = savingRepository.save(saving);
        return savingMapper.toDto(saved);
    }

    @Override
    public Saving updateSaving(Saving saving) {
        return savingRepository.save(saving);
    }

    @Override
    public Boolean deleteSaving(Long id) {
        savingRepository.deleteById(id);
        return true;
    }
}
