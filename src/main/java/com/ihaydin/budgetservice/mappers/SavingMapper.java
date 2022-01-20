package com.ihaydin.budgetservice.mappers;

import com.ihaydin.budgetservice.dto.SavingDto;
import com.ihaydin.budgetservice.model.Saving;

/**
 * @author ismailhakkiaydin
 * @date 20, January, 2022
 */
public interface SavingMapper {
    Saving toEntity(SavingDto savingDto);
    SavingDto toDto(Saving saving);
}
