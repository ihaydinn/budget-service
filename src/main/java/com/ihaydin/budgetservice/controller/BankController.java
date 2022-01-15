package com.ihaydin.budgetservice.controller;

import com.ihaydin.budgetservice.model.Bank;
import com.ihaydin.budgetservice.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/banks")
    public ResponseEntity<List<Bank>> getAllBanks() {
        List<Bank> bankList = bankService.findAll();
        return ResponseEntity.ok(bankList);
    }

    @GetMapping("/banks/{id}")
    public ResponseEntity<Bank> getSingleBank(@PathVariable Long id) {
        Optional<Bank> optionalBank = bankService.findById(id);
        Bank bankModel = null;
        if (optionalBank.isPresent()) {
            bankModel = optionalBank.get();
        }
        return ResponseEntity.ok(bankModel);
    }

    @PostMapping("/banks")
    public ResponseEntity<Bank> createBank(@RequestBody Bank bank) {
        Bank result = bankService.createBank(bank);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/banks/{id}")
    public ResponseEntity<Bank> updateBank(@PathVariable Long id, @RequestBody Bank bank) {
        Optional<Bank> optionalBank = bankService.findById(id);
        Bank bankModel = null;

        if (optionalBank.isPresent()) {
            bankModel = optionalBank.get();
        }
        assert bankModel != null;

        bankModel.setBankName(bank.getBankName());
        bankModel.setTotalAmount(bank.getTotalAmount());

        final Bank updateBank = bankService.updateBank(bankModel);
        return ResponseEntity.ok(updateBank);
    }

    @DeleteMapping("/banks/{id}")
    public ResponseEntity<Boolean> deleteBank(@PathVariable Long id) {
        return ResponseEntity.ok(bankService.deleteBank(id));
    }
}
