package com.ihaydin.budgetservice.service.impl;

import com.ihaydin.budgetservice.dto.AdsDto;
import com.ihaydin.budgetservice.mappers.AdsMapper;
import com.ihaydin.budgetservice.mappers.impl.AdsMapperImpl;
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

    public static AdsMapper adsMapper = AdsMapperImpl.getInstance();

    @Override
    public Optional<AdsDto> findById(Long id) {
        Optional<Ads> ads = adsRepository.findById(id);
        return adsMapper.toOptionalDto(ads);
    }

    @Override
    public AdsDto updateAds(AdsDto adsDto) {
        Ads ads = adsMapper.toEntity(adsDto);
        Ads updated = adsRepository.save(ads);
        return adsMapper.toDto(updated);
    }
}
