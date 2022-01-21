package com.ihaydin.budgetservice.mappers.impl;

import com.ihaydin.budgetservice.dto.PremiumDto;
import com.ihaydin.budgetservice.mappers.PremiumMapper;
import com.ihaydin.budgetservice.model.Premium;

import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 21, January, 2022
 */


public final class PremiumMapperImpl implements PremiumMapper {

    private static PremiumMapperImpl instance = new PremiumMapperImpl();

    public static PremiumMapperImpl getInstance() {
        return instance;
    }

    private PremiumMapperImpl() {
    }

    @Override
    public Premium toEntity(PremiumDto premiumDto) {
        Premium premium = new Premium();
        premium.setId(premiumDto.getId());
        premium.setPremium(premiumDto.isPremium());
        premium.setExpiredTime(premiumDto.getExpiredTime());
        return premium;
    }

    @Override
    public PremiumDto toDto(Premium premium) {
        PremiumDto premiumDto = new PremiumDto();
        premiumDto.setId(premium.getId());
        premiumDto.setPremium(premium.isPremium());
        premiumDto.setExpiredTime(premium.getExpiredTime());
        return premiumDto;
    }

    @Override
    public Optional<PremiumDto> toOptionalDto(Optional<Premium> optionalPremium) {
        Premium premium = optionalPremium.get();
        return Optional.of(this.toDto(premium));
    }
}
