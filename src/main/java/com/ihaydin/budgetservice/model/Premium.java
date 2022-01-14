package com.ihaydin.budgetservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author ismailhakkiaydin
 * @date 13, January, 2022
 */

@Getter
@Setter
@Entity
@Table(name = "tbl_premium")
public class Premium {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean isPremium;
    private Long expiredTime;
}
