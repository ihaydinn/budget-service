package com.ihaydin.budgetservice.repository;

import com.ihaydin.budgetservice.model.Saving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ismailhakkiaydin
 * @date 08, January, 2022
 */

@Repository
public interface SavingRepository extends JpaRepository<Saving, Long> {
}
