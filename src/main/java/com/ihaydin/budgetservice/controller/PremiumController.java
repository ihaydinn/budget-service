package com.ihaydin.budgetservice.controller;

import com.ihaydin.budgetservice.dto.PremiumDto;
import com.ihaydin.budgetservice.service.PremiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 13, January, 2022
 */

@RestController
@RequestMapping("/")
public class PremiumController {

    @Autowired
    private PremiumService premiumService;

    @GetMapping("/premium/{id}")
    public ResponseEntity<PremiumDto> getPremium(@PathVariable Long id){
        Optional<PremiumDto> premiumDtoId = premiumService.findById(id);
        PremiumDto premiumDtoModel = null;
        if (premiumDtoId.isPresent()){
            premiumDtoModel = premiumDtoId.get();
        }
        return ResponseEntity.ok(premiumDtoModel);
    }

    @PutMapping("/premium/{id}")
    public ResponseEntity<PremiumDto> updatePremium(@PathVariable Long id, @RequestBody PremiumDto premiumDto) {
        Optional<PremiumDto> premiumDtoId = premiumService.findById(id);
        PremiumDto premiumDtoModel = null;
        if (premiumDtoId.isPresent()) {
            premiumDtoModel = premiumDtoId.get();
        }
        assert premiumDtoModel != null;
        premiumDtoModel.setPremium(premiumDto.isPremium());
        premiumDtoModel.setExpiredTime(premiumDto.getExpiredTime());
        PremiumDto updatedPremium = premiumService.updatePremium(premiumDtoModel);
        return ResponseEntity.ok(updatedPremium);
    }

}
