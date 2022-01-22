package com.ihaydin.budgetservice.controller;

import com.ihaydin.budgetservice.dto.BankDto;
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
    public ResponseEntity<List<BankDto>> getAllBanks() {
        List<BankDto> bankDtoList = bankService.findAll();
        return ResponseEntity.ok(bankDtoList);
    }

    @GetMapping("/banks/{id}")
    public ResponseEntity<BankDto> getSingleBank(@PathVariable Long id) {
        Optional<BankDto> optionalDtoBank = bankService.findById(id);
        BankDto bankDtoModel = null;
        if (optionalDtoBank.isPresent()) {
            bankDtoModel = optionalDtoBank.get();
        }
        return ResponseEntity.ok(bankDtoModel);
    }

    @PostMapping("/banks")
    public ResponseEntity<BankDto> createBank(@RequestBody BankDto bankDto) {
        BankDto result = bankService.createBank(bankDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/banks/{id}")
    public ResponseEntity<BankDto> updateBank(@PathVariable Long id, @RequestBody Bank bank) {
        Optional<BankDto> optionalDtoBank = bankService.findById(id);
        BankDto bankDtoModel = null;

        if (optionalDtoBank.isPresent()) {
            bankDtoModel = optionalDtoBank.get();
        }
        assert bankDtoModel != null;

        bankDtoModel.setBankName(bank.getBankName());
        bankDtoModel.setTotalAmount(bank.getTotalAmount());

        final BankDto updateBank = bankService.updateBank(bankDtoModel);
        return ResponseEntity.ok(updateBank);
    }

    @DeleteMapping("/banks/{id}")
    public ResponseEntity<Boolean> deleteBank(@PathVariable Long id) {
        return ResponseEntity.ok(bankService.deleteBank(id));
    }
}
