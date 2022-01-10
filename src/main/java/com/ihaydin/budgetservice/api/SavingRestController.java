package com.ihaydin.budgetservice.api;

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
public class SavingRestController {

    @Autowired
    private SavingService savingService;

    @GetMapping("/savings")
    public ResponseEntity<List<Saving>> getAllSaving(){
        List<Saving> savingList = savingService.findAll();
        return ResponseEntity.ok(savingList);
    }

    @GetMapping("/saving/{id}")
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
}
