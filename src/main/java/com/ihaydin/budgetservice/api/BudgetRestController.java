package com.ihaydin.budgetservice.api;

import com.ihaydin.budgetservice.model.Budget;
import com.ihaydin.budgetservice.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class BudgetRestController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping("/budgets")
    public ResponseEntity<List<Budget>> getAllBudgets(){
        List<Budget> budgetList = budgetService.findAll();
        return ResponseEntity.ok(budgetList);
    }

    @GetMapping("/budget/{id}")
    public ResponseEntity<Budget> getSingleBudget(@PathVariable Long id){
        Optional<Budget> budgetId = budgetService.findById(id);
        Budget budgetModel = null;
        if (budgetId.isPresent()){
            budgetModel = budgetId.get();
        }
        return ResponseEntity.ok(budgetModel);
    }

    @PostMapping("/budgets")
    public ResponseEntity<Budget> createBudget(@RequestBody Budget budget){
        Budget result = budgetService.createBudget(budget);
        return ResponseEntity.ok(result);
    }


}
