package com.ihaydin.budgetservice.controller;

import com.ihaydin.budgetservice.model.Saving;
import com.ihaydin.budgetservice.service.SavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author ismailhakkiaydin
 * @date 08, January, 2022
 */

@RestController
@RequestMapping("/")
public class SavingController {

    @Autowired
    private SavingService savingService;

    @GetMapping("/savings")
    public ResponseEntity<List<Saving>> getAllSaving(){
        List<Saving> savingList = savingService.findAll();
        return ResponseEntity.ok(savingList);
    }

    @GetMapping("/savings/{id}")
    public ResponseEntity<Saving> getSingleSaving(@PathVariable Long id){
        Optional<Saving> savingId =  savingService.findById(id);
        Saving savingModel = null;
        if (savingId.isPresent()){
            savingModel = savingId.get();
        }
        return ResponseEntity.ok(savingModel);
    }

    @PostMapping("/savings")
    public ResponseEntity<Saving> createSaving(@RequestBody Saving saving){
        Saving result = savingService.createSaving(saving);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/savings/{id}")
    public ResponseEntity<Saving> updateSaving(@PathVariable Long id, @RequestBody Saving saving){
        Optional<Saving> savingId = savingService.findById(id);
        Saving savingModel = null;
        if (savingId.isPresent()){
            savingModel = savingId.get();
        }
        assert savingModel != null;
        savingModel.setAmount(saving.getAmount());

        final Saving updatedSaving = savingService.updateSaving(savingModel);
        return ResponseEntity.ok(updatedSaving);
    }

    @DeleteMapping("/savings/{id}")
    public ResponseEntity<Boolean> deleteSaving(@PathVariable Long id){
        return ResponseEntity.ok(savingService.deleteSaving(id));
    }
}
