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
@Table(name = "tbl_ads")
public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean isNoAds;
}
