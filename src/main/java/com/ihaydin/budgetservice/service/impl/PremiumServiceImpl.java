package com.ihaydin.budgetservice.service.impl;

import com.ihaydin.budgetservice.dto.PremiumDto;
import com.ihaydin.budgetservice.mappers.PremiumMapper;
import com.ihaydin.budgetservice.mappers.impl.PremiumMapperImpl;
import com.ihaydin.budgetservice.model.Premium;
import com.ihaydin.budgetservice.repository.PremiumRepository;
import com.ihaydin.budgetservice.service.PremiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 13, January, 2022
 */

@Service
public class PremiumServiceImpl implements PremiumService {

    @Autowired
    PremiumRepository premiumRepository;

    private static PremiumMapper premiumMapper = PremiumMapperImpl.getInstance();

    @Override
    public Optional<PremiumDto> findById(Long id) {
        Optional<Premium> premium = premiumRepository.findById(id);
        return premiumMapper.toOptionalDto(premium);
    }

    @Override
    public PremiumDto updatePremium(PremiumDto premiumDto) {
        Premium premium = premiumMapper.toEntity(premiumDto);
        Premium updated = premiumRepository.save(premium);
        return premiumMapper.toDto(updated);
    }
}
