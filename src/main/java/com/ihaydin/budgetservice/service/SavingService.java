package com.ihaydin.budgetservice.service;

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
    Saving createSaving(Saving saving);
    Saving updateSaving(Saving saving);
}
