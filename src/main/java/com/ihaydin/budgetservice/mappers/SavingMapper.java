package com.ihaydin.budgetservice.mappers;

import com.ihaydin.budgetservice.dto.SavingDto;
import com.ihaydin.budgetservice.model.Saving;

import java.util.List;
import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 20, January, 2022
 */
public interface SavingMapper {
    Saving toEntity(SavingDto savingDto);
    SavingDto toDto(Saving saving);
    List<SavingDto> toListDto(List<Saving> savingList);
    Optional<SavingDto> toOptionalDto(Optional<Saving> savingOptional);
}
