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
    public ResponseEntity<BudgetDto> updateBudget(@PathVariable Long id, @RequestBody Budget budget) {
        Optional<BudgetDto> optionalBudgetDto = budgetService.findById(id);
        BudgetDto budgetDtoModel = null;
        if (optionalBudgetDto.isPresent()) {
            budgetDtoModel = optionalBudgetDto.get();
        }
        assert budgetDtoModel != null;
        budgetDtoModel.setCategory(budget.getCategory());
        budgetDtoModel.setTargetValue(budget.getTargetValue());
        budgetDtoModel.setTime(budget.getTime());
        budgetDtoModel.setActive(budget.isActive());

        final BudgetDto updatedBudget = budgetService.updateBudget(budgetDtoModel);
        return ResponseEntity.ok(updatedBudget);

    }

    @DeleteMapping("/budgets/{id}")
    public ResponseEntity<Boolean> deleteBudget(@PathVariable Long id) {
        return ResponseEntity.ok(budgetService.deleteBudget(id));
    }


}
