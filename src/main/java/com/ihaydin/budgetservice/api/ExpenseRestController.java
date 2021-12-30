package com.ihaydin.budgetservice.api;

import com.ihaydin.budgetservice.model.Expense;
import com.ihaydin.budgetservice.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ExpenseRestController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping(value = "/expenses")
    public ResponseEntity<List<Expense>> getAllExpense() {
        List<Expense> expenseList = expenseService.findAll();
        return ResponseEntity.ok(expenseList);
    }

    @GetMapping(value = "/expense/{id}")
    public ResponseEntity<Expense> getSingleIncome(@PathVariable Long id) {
        Optional<Expense> expenseId = expenseService.findById(id);
        Expense expenseModel = null;
        if (expenseId.isPresent()){
            expenseModel = expenseId.get();
        }

        return ResponseEntity.ok(expenseModel);
    }
}
