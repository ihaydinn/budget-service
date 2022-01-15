package com.ihaydin.budgetservice.controller;

import com.ihaydin.budgetservice.model.Income;
import com.ihaydin.budgetservice.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/")
public class IncomeController {
    @Autowired
    private IncomeService incomeService;

    @GetMapping(value = "/incomes")
    public ResponseEntity<List<Income>> getAllIncomes() {
        List<Income> incomeList = incomeService.findAll();
        return ResponseEntity.ok(incomeList);
    }

    @GetMapping(value = "/income/{id}")
    public ResponseEntity<Income> getSingleIncome(@PathVariable Long id) {
        Optional<Income> incomeId = incomeService.findById(id);
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

    @PutMapping(value = "/income/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id, @RequestBody Income income){
        Optional<Income> optionalIncome = incomeService.findById(id);
        Income incomeModel = null;
        if (optionalIncome.isPresent()){
            incomeModel = optionalIncome.get();
        }
        assert incomeModel != null;
        incomeModel.setCategory(income.getCategory());
        incomeModel.setBankName(income.getBankName());
        incomeModel.setDescription(income.getDescription());
        incomeModel.setDate(income.getDate());
        incomeModel.setPrice(income.getPrice());

        final Income updatedIncome = incomeService.createIncome(incomeModel);
        return ResponseEntity.ok(updatedIncome);

    }

    @DeleteMapping(value = "/income/{id}")
    public ResponseEntity<Boolean> deleteIncome(@PathVariable Long id){
        return ResponseEntity.ok(incomeService.deleteIncome(id));
    }


}
