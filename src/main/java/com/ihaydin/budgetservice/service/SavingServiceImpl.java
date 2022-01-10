package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.model.Saving;
import com.ihaydin.budgetservice.repository.SavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 08, January, 2022
 */

@Service
public class SavingServiceImpl implements SavingService{

    @Autowired
    SavingRepository savingRepository;

    @Override
    public List<Saving> findAll() {
        return savingRepository.findAll();
    }

    @Override
    public Optional<Saving> findById(Long id) {
        return savingRepository.findById(id);
    }

    @Override
    public Saving createSaving(Saving saving) {
        return savingRepository.save(saving);
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
