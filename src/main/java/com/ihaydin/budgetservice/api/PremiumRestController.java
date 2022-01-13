package com.ihaydin.budgetservice.api;

import com.ihaydin.budgetservice.model.Premium;
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
public class PremiumRestController {

    @Autowired
    private PremiumService premiumService;

    @RequestMapping("/premium/{id}")
    public ResponseEntity<Premium> getPremium(@PathVariable Long id){
        Optional<Premium> premiumId = premiumService.findById(id);
        Premium premiumModel = null;
        if (premiumId.isPresent()){
            premiumModel = premiumId.get();
        }
        return ResponseEntity.ok(premiumModel);
    }

    @PutMapping("/premium/{id}")
    public ResponseEntity<Premium> updatePremium(@PathVariable Long id, @RequestBody Premium premium) {
        Optional<Premium> premiumId = premiumService.findById(id);
        Premium premiumModel = null;
        if (premiumId.isPresent()) {
            premiumModel = premiumId.get();
        }
        assert premiumModel != null;
        premiumModel.setPremium(premium.isPremium());
        premiumModel.setExpiredTime(premium.getExpiredTime());
        Premium updatedPremium = premiumService.updatePremium(premiumModel);
        return ResponseEntity.ok(updatedPremium);
    }

}
