package com.ihaydin.budgetservice.api;

import com.ihaydin.budgetservice.model.Expense;
import com.ihaydin.budgetservice.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/expenses")
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        Expense result = expenseService.createExpense(expense);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/expense/{id}")
    public ResponseEntity<Expense> updateIncome(@PathVariable Long id, @RequestBody Expense expense){
        Optional<Expense> optionalExpense = expenseService.findById(id);
        Expense expenseModel = null;
        if (optionalExpense.isPresent()){
            expenseModel = optionalExpense.get();
        }
        assert expenseModel != null;
        expenseModel.setCategory(expense.getCategory());
        expenseModel.setBankName(expense.getBankName());
        expenseModel.setDescription(expense.getDescription());
        expenseModel.setDate(expense.getDate());
        expenseModel.setPrice(expense.getPrice());

        final Expense updatedExpense = expenseService.updateExpense(expenseModel);
        return ResponseEntity.ok(updatedExpense);

    }
}
