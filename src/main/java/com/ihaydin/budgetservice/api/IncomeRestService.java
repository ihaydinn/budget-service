package com.ihaydin.budgetservice.api;

import com.ihaydin.budgetservice.model.Income;
import com.ihaydin.budgetservice.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class IncomeRestService {
    @Autowired
    private IncomeService incomeService;

    @GetMapping(value = "/incomes")
    public ResponseEntity<List<Income>> getAllIncomes(){
        List<Income> incomeList = incomeService.findAll();
        return ResponseEntity.ok(incomeList);
    }

    @PostMapping(value = "/incomes")
    public ResponseEntity<Income> createIncome(@RequestBody Income income){
        Income result = incomeService.createIncome(income);
        return ResponseEntity.ok(result);
    }

}
