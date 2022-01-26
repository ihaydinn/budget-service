package com.ihaydin.budgetservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ismailhakkiaydin
 * @date 08, January, 2022
 */

@Data
@Entity
@NoArgsConstructor
@Table(name = "tbl_saving")
public class Saving implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String amount;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "budget_id", nullable = false)
    private Budget budget;

}
