package com.ihaydin.budgetservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_income")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String category;
    private String bankName;
    private String description;
    private String price;
    private long date;

}
