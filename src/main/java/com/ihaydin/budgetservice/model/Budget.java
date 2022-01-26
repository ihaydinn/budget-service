package com.ihaydin.budgetservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_budget")
public class Budget implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private String targetValue;
    private Long time;
    private boolean isActive;

    @JsonIgnore
    @JoinColumn(name = "budget_id")
    @OneToMany(fetch= FetchType.EAGER)
    private List<Saving> savings;

}
