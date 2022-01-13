package com.ihaydin.budgetservice.api;

import com.ihaydin.budgetservice.model.Ads;
import com.ihaydin.budgetservice.service.AdsService;
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
public class AdsRestController {

    @Autowired
    private AdsService adsService;

    @GetMapping("/ads/{id}")
    public ResponseEntity<Ads> getAds(@PathVariable Long id){
        Optional<Ads> adsId = adsService.findById(id);
        Ads adsModel = null;
        if (adsId.isPresent()){
            adsModel = adsId.get();
        }
        return ResponseEntity.ok(adsModel);
    }

    @PutMapping("/ads/{id}")
    public ResponseEntity<Ads> updateAds(@PathVariable Long id, @RequestBody Ads ads){
        Optional<Ads> adsId = adsService.findById(id);
        Ads adsModel = null;
        if (adsId.isPresent()){
            adsModel = adsId.get();
        }
        assert adsModel != null;
        adsModel.setNoAds(ads.isNoAds());

        Ads updatedAds = adsService.updateAds(adsModel);
        return ResponseEntity.ok(updatedAds);
    }

}
