package com.ihaydin.budgetservice.controller;

import com.ihaydin.budgetservice.dto.BudgetDto;
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
    public ResponseEntity<List<BudgetDto>> getAllBudgets() {
        List<BudgetDto> budgetList = budgetService.findAll();
        return ResponseEntity.ok(budgetList);
    }

    @GetMapping("/budgets/{id}")
    public ResponseEntity<BudgetDto> getSingleBudget(@PathVariable Long id) {
        Optional<BudgetDto> budgetDtoId = budgetService.findById(id);
        BudgetDto budgetDtoModel = null;
        if (budgetDtoId.isPresent()) {
            budgetDtoModel = budgetDtoId.get();
        }
        return ResponseEntity.ok(budgetDtoModel);
    }

    @PostMapping("/budgets")
    public ResponseEntity<BudgetDto> createBudget(@RequestBody BudgetDto budgetDto) {
        BudgetDto result = budgetService.createBudget(budgetDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/budgets/{id}")
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

    @DeleteMapping("/budgets/{id}")
    public ResponseEntity<Boolean> deleteBudget(@PathVariable Long id) {
        return ResponseEntity.ok(budgetService.deleteBudget(id));
    }


}
