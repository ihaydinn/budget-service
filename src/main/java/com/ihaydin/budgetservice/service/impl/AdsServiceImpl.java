package com.ihaydin.budgetservice.service.impl;

import com.ihaydin.budgetservice.model.Ads;
import com.ihaydin.budgetservice.repository.AdsRepository;
import com.ihaydin.budgetservice.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 13, January, 2022
 */

@Service
public class AdsServiceImpl implements AdsService {

    @Autowired
    AdsRepository adsRepository;

    @Override
    public Optional<Ads> findById(Long id) {
        return adsRepository.findById(id);
    }

    @Override
    public Ads updateAds(Ads ads) {
        return adsRepository.save(ads);
    }
}
