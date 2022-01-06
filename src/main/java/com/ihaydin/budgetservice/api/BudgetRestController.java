package com.ihaydin.budgetservice.api;

import com.ihaydin.budgetservice.model.Budget;
import com.ihaydin.budgetservice.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class BudgetRestController {

    @Autowired
    private BudgetService budgetService;

    public ResponseEntity<List<Budget>> getAllBudgets(){
        List<Budget> budgetList = budgetService.findAll();
        return ResponseEntity.ok(budgetList);
    }

}
