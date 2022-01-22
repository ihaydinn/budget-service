package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.dto.SavingDto;

import java.util.List;
import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 08, January, 2022
 */
public interface SavingService {
    List<SavingDto> findAll();
    Optional<SavingDto> findById(Long id);
    SavingDto createSaving(SavingDto savingDto);
    SavingDto updateSaving(SavingDto savingDto);
    Boolean deleteSaving(Long id);
}
