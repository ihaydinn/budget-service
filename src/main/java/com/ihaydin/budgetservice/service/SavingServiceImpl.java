package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.model.Saving;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ismailhakkiaydin
 * @date 08, January, 2022
 */

@Service
public class SavingServiceImpl implements SavingService{

    @Autowired
    SavingService savingService;

    @Override
    public List<Saving> findAll() {
        return savingService.findAll();
    }
}