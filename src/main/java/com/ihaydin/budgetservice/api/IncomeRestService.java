package com.ihaydin.budgetservice.api;

import com.ihaydin.budgetservice.model.Income;
import com.ihaydin.budgetservice.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/")
public class IncomeRestService {
    @Autowired
    private IncomeService incomeService;

    @GetMapping(value = "/incomes")
    public ResponseEntity<List<Income>> getAllIncomes() {
        List<Income> incomeList = incomeService.findAll();
        return ResponseEntity.ok(incomeList);
    }

    @GetMapping(value = "/income/{uuid}")
    public ResponseEntity<Income> getSingleIncome(@PathVariable UUID uuid) {
        Optional<Income> incomeId = incomeService.findById(uuid);
        Income incomeModel = null;
        if (incomeId.isPresent()){
            incomeModel = incomeId.get();
        }
        
        return ResponseEntity.ok(incomeModel);
    }

    @PostMapping(value = "/incomes")
    public ResponseEntity<Income> createIncome(@RequestBody Income income) {
        Income result = incomeService.createIncome(income);
        return ResponseEntity.ok(result);
    }

}
