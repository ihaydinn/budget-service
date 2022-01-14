package com.ihaydin.budgetservice.repository;

import com.ihaydin.budgetservice.model.Premium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ismailhakkiaydin
 * @date 13, January, 2022
 */

@Repository
public interface PremiumRepository extends JpaRepository<Premium, Long> {
}
