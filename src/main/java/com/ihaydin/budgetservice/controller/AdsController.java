package com.ihaydin.budgetservice.controller;

import com.ihaydin.budgetservice.dto.AdsDto;
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
public class AdsController {

    @Autowired
    private AdsService adsService;

    @GetMapping("/ads/{id}")
    public ResponseEntity<AdsDto> getAds(@PathVariable Long id) {
        Optional<AdsDto> adsDtoId = adsService.findById(id);
        AdsDto adsDtoModel = null;
        if (adsDtoId.isPresent()) {
            adsDtoModel = adsDtoId.get();
        }
        return ResponseEntity.ok(adsDtoModel);
    }

    @PutMapping("/ads/{id}")
    public ResponseEntity<AdsDto> updateAds(@PathVariable Long id, @RequestBody AdsDto adsDto) {
        Optional<AdsDto> adsDtoId = adsService.findById(id);
        AdsDto adsDtoModel = null;
        if (adsDtoId.isPresent()) {
            adsDtoModel = adsDtoId.get();
        }
        assert adsDtoModel != null;
        adsDtoModel.setNoAds(adsDto.isNoAds());

        AdsDto updatedAds = adsService.updateAds(adsDtoModel);
        return ResponseEntity.ok(updatedAds);
    }

}
