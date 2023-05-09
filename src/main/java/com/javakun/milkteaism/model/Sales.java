package com.javakun.milkteaism.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
@Entity
@Table
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sales_id", nullable = false)
    private Long salesId;
    @Column(name = "beverage_key", nullable = false)
    private String beverageKey;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "total_amount", nullable = false)
    private Integer totalAmount;
    @Column(name = "date", nullable = false)
    private String date;

}
