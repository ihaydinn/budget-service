package com.ihaydin.budgetservice.mappers;

import com.ihaydin.budgetservice.dto.PremiumDto;
import com.ihaydin.budgetservice.model.Premium;

import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 21, January, 2022
 */
public interface PremiumMapper {
    Premium toEntity(PremiumDto premiumDto);
    PremiumDto toDto(Premium premium);
    Optional<PremiumDto> toOptionalDto(Optional<Premium> premium);

}
