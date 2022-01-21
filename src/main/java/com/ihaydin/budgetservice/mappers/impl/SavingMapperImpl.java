package com.ihaydin.budgetservice.mappers.impl;

import com.ihaydin.budgetservice.dto.SavingDto;
import com.ihaydin.budgetservice.mappers.SavingMapper;
import com.ihaydin.budgetservice.model.Saving;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 20, January, 2022
 */

public final class SavingMapperImpl implements SavingMapper {

    public static SavingMapperImpl instance = new SavingMapperImpl();

    private SavingMapperImpl(){
    }

    public static SavingMapperImpl getInstance(){
        return instance;
    }

    @Override
    public Saving toEntity(SavingDto savingDto) {
        Saving saving = new Saving();
        saving.setId(savingDto.getId());
        saving.setAmount(savingDto.getAmount());
        return saving;
    }

    @Override
    public SavingDto toDto(Saving saving) {
        SavingDto savingDto = new SavingDto();
        savingDto.setId(saving.getId());
        savingDto.setAmount(saving.getAmount());
        return savingDto;
    }

    @Override
    public List<SavingDto> toListDto(List<Saving> savingList) {
        List<SavingDto> savingDtoList = new ArrayList<>(savingList.size());
        for (Saving saving : savingList) {
            savingDtoList.add(this.toDto(saving));
        }
        return null;
    }

    @Override
    public Optional<SavingDto> toOptionalDto(Optional<Saving> savingOptional) {
        Saving saving = savingOptional.get();
        return Optional.of(this.toDto(saving));
    }
}
