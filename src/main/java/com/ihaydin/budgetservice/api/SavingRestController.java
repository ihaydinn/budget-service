package com.ihaydin.budgetservice.api;

import com.ihaydin.budgetservice.model.Saving;
import com.ihaydin.budgetservice.service.SavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
