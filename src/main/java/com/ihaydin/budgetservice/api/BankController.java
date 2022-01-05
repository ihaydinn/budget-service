package com.ihaydin.budgetservice.api;

import com.ihaydin.budgetservice.model.Bank;
import com.ihaydin.budgetservice.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/banks")
    public ResponseEntity<List<Bank>> getAllBanks(){
        List<Bank> bankList = bankService.findAll();
        return ResponseEntity.ok(bankList);
    }
}
