package com.ihaydin.budgetservice.controller;

import com.ihaydin.budgetservice.dto.IncomeDto;
import com.ihaydin.budgetservice.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/")
public class IncomeController {
    @Autowired
    private IncomeService incomeService;

    @GetMapping(value = "/incomes")
    public ResponseEntity<List<IncomeDto>> getAllIncomes() {
        List<IncomeDto> incomeList = incomeService.findAll();
        return ResponseEntity.ok(incomeList);
    }

    @GetMapping(value = "/incomes/{id}")
    public ResponseEntity<IncomeDto> getSingleIncome(@PathVariable Long id) {
        Optional<IncomeDto> incomeDtoId = incomeService.findById(id);
        IncomeDto incomeDtoModel = null;
        if (incomeDtoId.isPresent()) {
            incomeDtoModel = incomeDtoId.get();
        }

        return ResponseEntity.ok(incomeDtoModel);
    }

    @PostMapping(value = "/incomes")
    public ResponseEntity<IncomeDto> createIncome(@RequestBody IncomeDto incomeDto) {
        IncomeDto result = incomeService.createIncome(incomeDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/incomes/{id}")
    public ResponseEntity<IncomeDto> updateIncome(@PathVariable Long id, @RequestBody IncomeDto incomeDto) {
        Optional<IncomeDto> optionalDtoIncome = incomeService.findById(id);
        IncomeDto incomeDtoModel = null;
        if (optionalDtoIncome.isPresent()) {
            incomeDtoModel = optionalDtoIncome.get();
        }
        assert incomeDtoModel != null;
        incomeDtoModel.setCategory(incomeDto.getCategory());
        incomeDtoModel.setBankName(incomeDto.getBankName());
        incomeDtoModel.setDescription(incomeDto.getDescription());
        incomeDtoModel.setDate(incomeDto.getDate());
        incomeDtoModel.setPrice(incomeDto.getPrice());

        final IncomeDto updatedIncome = incomeService.createIncome(incomeDtoModel);
        return ResponseEntity.ok(updatedIncome);

    }

    @DeleteMapping(value = "/incomes/{id}")
    public ResponseEntity<Boolean> deleteIncome(@PathVariable Long id) {
        return ResponseEntity.ok(incomeService.deleteIncome(id));
    }


}
