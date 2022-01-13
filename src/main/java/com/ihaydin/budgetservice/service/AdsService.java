package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.model.Ads;

import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 13, January, 2022
 */
public interface AdsService {
    Optional<Ads> findById(Long id);
    Ads updateAds(Ads ads);
}
