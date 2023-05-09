package com.javakun.milkteaism.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "milktea")
public class Milktea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "milktea_id", nullable = false)
    private Long milkteaId;
    @Column(name = "beverage_key", nullable = false)
    private String beverageKey;
    @Column(name = "flavor", nullable = false)
    private String flavor;
    @Column(name = "size", nullable = false)
    private String size;
    @Column(name = "amount", nullable = false)
    private Integer amount;
}
