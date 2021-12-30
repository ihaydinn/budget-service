package com.ihaydin.budgetservice.api;

import com.ihaydin.budgetservice.model.Expense;
import com.ihaydin.budgetservice.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
