package com.ihaydin.budgetservice.mappers.impl;

import com.ihaydin.budgetservice.dto.AdsDto;
import com.ihaydin.budgetservice.mappers.AdsMapper;
import com.ihaydin.budgetservice.model.Ads;

import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 21, January, 2022
 */

public final class AdsMapperImpl implements AdsMapper {

    public static AdsMapperImpl instance = new AdsMapperImpl();

    private AdsMapperImpl() {
    }

    public static AdsMapperImpl getInstance() {
        return instance;
    }

    @Override
    public Ads toEntity(AdsDto adsDto) {
        Ads ads = new Ads();
        ads.setId(adsDto.getId());
        ads.setNoAds(adsDto.isNoAds());
        return ads;
    }

    @Override
    public AdsDto toDto(Ads ads) {
        AdsDto adsDto = new AdsDto();
        adsDto.setId(ads.getId());
        adsDto.setNoAds(ads.isNoAds());
        return adsDto;
    }

    @Override
    public Optional<AdsDto> toOptionalDto(Optional<Ads> optionalAds) {
        Ads ads = optionalAds.get();
        return Optional.of(this.toDto(ads));
    }
}
