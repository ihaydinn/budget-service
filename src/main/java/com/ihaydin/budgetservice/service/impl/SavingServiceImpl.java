package com.ihaydin.budgetservice.service.impl;

import com.ihaydin.budgetservice.dto.SavingDto;
import com.ihaydin.budgetservice.mappers.SavingMapper;
import com.ihaydin.budgetservice.mappers.impl.SavingMapperImpl;
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
    public List<SavingDto> findAll() {
        List<Saving> savingList = savingRepository.findAll();
        return savingMapper.toListDto(savingList);
    }

    @Override
    public Optional<SavingDto> findById(Long id) {
        Optional<Saving> saving = savingRepository.findById(id);
        return savingMapper.toOptionalDto(saving);
    }

    @Override
    public SavingDto createSaving(SavingDto savingDto) {
        Saving saving = savingMapper.toEntity(savingDto);
        Saving saved = savingRepository.save(saving);
        return savingMapper.toDto(saved);
    }

    @Override
    public SavingDto updateSaving(SavingDto savingDto) {
        Saving saving = savingMapper.toEntity(savingDto);
        Saving updated = savingRepository.save(saving);
        return savingMapper.toDto(updated);
    }

    @Override
    public Boolean deleteSaving(Long id) {
        savingRepository.deleteById(id);
        return true;
    }
}
