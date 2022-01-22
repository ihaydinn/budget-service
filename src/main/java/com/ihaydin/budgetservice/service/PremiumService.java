package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.dto.PremiumDto;

import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 13, January, 2022
 */
public interface PremiumService {
    Optional<PremiumDto> findById(Long id);
    PremiumDto updatePremium(PremiumDto premiumDto);
}
