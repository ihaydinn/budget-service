package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.dto.BudgetDto;
import com.ihaydin.budgetservice.dto.SavingDto;
import com.ihaydin.budgetservice.model.Saving;

import java.util.List;
import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 08, January, 2022
 */
public interface SavingService {
    List<Saving> findAll();
    Optional<Saving> findById(Long id);
    SavingDto createSaving(SavingDto savingDto);
    Saving updateSaving(Saving saving);
    Boolean deleteSaving(Long id);
}
