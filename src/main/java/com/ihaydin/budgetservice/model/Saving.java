package com.ihaydin.budgetservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author ismailhakkiaydin
 * @date 08, January, 2022
 */

@Getter
@Setter
@Entity
@Table(name = "tbl_saving")
public class Saving {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String amount;
}
