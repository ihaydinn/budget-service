package com.ihaydin.budgetservice.service;

import com.ihaydin.budgetservice.model.Saving;

import java.util.List;

/**
 * @author ismailhakkiaydin
 * @date 08, January, 2022
 */
public interface SavingService {
    List<Saving> findAll();
}
