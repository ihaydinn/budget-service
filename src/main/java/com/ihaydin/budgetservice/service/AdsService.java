package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.dto.AdsDto;

import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 13, January, 2022
 */
public interface AdsService {
    Optional<AdsDto> findById(Long id);
    AdsDto updateAds(AdsDto adsDto);
}
