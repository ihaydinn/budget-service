package com.ihaydin.budgetservice.repository;

import com.ihaydin.budgetservice.model.Ads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ismailhakkiaydin
 * @date 13, January, 2022
 */

@Repository
public interface AdsRepository extends JpaRepository<Ads, Long> {
}
