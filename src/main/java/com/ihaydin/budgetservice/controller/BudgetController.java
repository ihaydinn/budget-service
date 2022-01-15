package com.ihaydin.budgetservice.controller;

import com.ihaydin.budgetservice.model.Budget;
import com.ihaydin.budgetservice.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping("/budgets")
    public ResponseEntity<List<Budget>> getAllBudgets() {
        List<Budget> budgetList = budgetService.findAll();
        return ResponseEntity.ok(budgetList);
    }

    @GetMapping("/budget/{id}")
    public ResponseEntity<Budget> getSingleBudget(@PathVariable Long id) {
        Optional<Budget> budgetId = budgetService.findById(id);
        Budget budgetModel = null;
        if (budgetId.isPresent()) {
            budgetModel = budgetId.get();
        }
        return ResponseEntity.ok(budgetModel);
    }

    @PostMapping("/budgets")
    public ResponseEntity<Budget> createBudget(@RequestBody Budget budget) {
        Budget result = budgetService.createBudget(budget);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/budget/{id}")
    public ResponseEntity<Budget> updateBudget(@PathVariable Long id, @RequestBody Budget budget) {
        Optional<Budget> optionalBudget = budgetService.findById(id);
        Budget budgetModel = null;
        if (optionalBudget.isPresent()) {
            budgetModel = optionalBudget.get();
        }
        assert budgetModel != null;
        budgetModel.setCategory(budget.getCategory());
        budgetModel.setTargetValue(budget.getTargetValue());
        budgetModel.setTime(budget.getTime());
        budgetModel.setActive(budget.isActive());

        final Budget updatedBudget = budgetService.updateBudget(budgetModel);
        return ResponseEntity.ok(updatedBudget);

    }

    @DeleteMapping("/budget/{id}")
    public ResponseEntity<Boolean> deleteBudget(@PathVariable Long id) {
        return ResponseEntity.ok(budgetService.deleteBudget(id));
    }


}
