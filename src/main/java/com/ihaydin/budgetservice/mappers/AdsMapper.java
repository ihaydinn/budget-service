package com.ihaydin.budgetservice.mappers;

import com.ihaydin.budgetservice.dto.AdsDto;
import com.ihaydin.budgetservice.model.Ads;

import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 21, January, 2022
 */
public interface AdsMapper {
    Ads toEntity(AdsDto adsDto);
    AdsDto toDto(Ads ads);
    Optional<AdsDto> toOptionalDto(Optional<Ads> optionalAds);

}
