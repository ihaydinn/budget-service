package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.model.Premium;

import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 13, January, 2022
 */
public interface PremiumService {
    Optional<Premium> findById(Long id);
    Premium updatePremium(Premium premium);
}
