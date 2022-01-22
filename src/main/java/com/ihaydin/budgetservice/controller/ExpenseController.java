package com.ihaydin.budgetservice.controller;

import com.ihaydin.budgetservice.dto.ExpenseDto;
import com.ihaydin.budgetservice.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping(value = "/expenses")
    public ResponseEntity<List<ExpenseDto>> getAllExpense() {
        List<ExpenseDto> expenseDtoList = expenseService.findAll();
        return ResponseEntity.ok(expenseDtoList);
    }

    @GetMapping(value = "/expenses/{id}")
    public ResponseEntity<ExpenseDto> getSingleIncome(@PathVariable Long id) {
        Optional<ExpenseDto> expenseDtoId = expenseService.findById(id);
        ExpenseDto expenseDtoModel = null;
        if (expenseDtoId.isPresent()) {
            expenseDtoModel = expenseDtoId.get();
        }

        return ResponseEntity.ok(expenseDtoModel);
    }

    @PostMapping(value = "/expenses")
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto) {
        ExpenseDto result = expenseService.createExpense(expenseDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/expenses/{id}")
    public ResponseEntity<ExpenseDto> updateIncome(@PathVariable Long id, @RequestBody ExpenseDto expenseDto) {
        Optional<ExpenseDto> optionalDtoExpense = expenseService.findById(id);
        ExpenseDto expenseDtoModel = null;
        if (optionalDtoExpense.isPresent()) {
            expenseDtoModel = optionalDtoExpense.get();
        }
        assert expenseDtoModel != null;
        expenseDtoModel.setCategory(expenseDto.getCategory());
        expenseDtoModel.setBankName(expenseDto.getBankName());
        expenseDtoModel.setDescription(expenseDto.getDescription());
        expenseDtoModel.setDate(expenseDto.getDate());
        expenseDtoModel.setPrice(expenseDto.getPrice());

        final ExpenseDto updatedExpense = expenseService.updateExpense(expenseDtoModel);
        return ResponseEntity.ok(updatedExpense);

    }

    @DeleteMapping(value = "/expenses/{id}")
    public ResponseEntity<Boolean> deleteExpense(@PathVariable Long id) {
        return ResponseEntity.ok(expenseService.deleteExpense(id));
    }
}
