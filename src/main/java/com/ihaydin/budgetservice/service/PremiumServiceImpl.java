package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.model.Premium;
import com.ihaydin.budgetservice.repository.PremiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 13, January, 2022
 */

@Service
public class PremiumServiceImpl implements PremiumService{

    @Autowired
    PremiumRepository premiumRepository;

    @Override
    public Optional<Premium> findById(Long id) {
        return premiumRepository.findById(id);
    }

    @Override
    public Premium updatePremium(Premium premium) {
        return premiumRepository.save(premium);
    }
}
