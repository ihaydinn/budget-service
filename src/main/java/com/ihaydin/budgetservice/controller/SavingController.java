package com.ihaydin.budgetservice.controller;

import com.ihaydin.budgetservice.dto.SavingDto;
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
    public ResponseEntity<List<SavingDto>> getAllSaving() {
        List<SavingDto> savingList = savingService.findAll();
        return ResponseEntity.ok(savingList);
    }

    @GetMapping("/savings/{id}")
    public ResponseEntity<SavingDto> getSingleSaving(@PathVariable Long id) {
        Optional<SavingDto> savingDtoId = savingService.findById(id);
        SavingDto savingDto = null;
        if (savingDtoId.isPresent()) {
            savingDto = savingDtoId.get();
        }
        return ResponseEntity.ok(savingDto);
    }

    @PostMapping("/savings")
    public ResponseEntity<SavingDto> createSaving(@RequestBody SavingDto savingDto) {
        SavingDto result = savingService.createSaving(savingDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/savings/{id}")
    public ResponseEntity<SavingDto> updateSaving(@PathVariable Long id, @RequestBody SavingDto savingDto) {
        Optional<SavingDto> savingDtoId = savingService.findById(id);
        SavingDto savingDtoModel = null;
        if (savingDtoId.isPresent()) {
            savingDtoModel = savingDtoId.get();
        }
        assert savingDtoModel != null;
        savingDtoModel.setAmount(savingDto.getAmount());

        final SavingDto updatedSaving = savingService.updateSaving(savingDtoModel);
        return ResponseEntity.ok(updatedSaving);
    }

    @DeleteMapping("/savings/{id}")
    public ResponseEntity<Boolean> deleteSaving(@PathVariable Long id) {
        return ResponseEntity.ok(savingService.deleteSaving(id));
    }
}
