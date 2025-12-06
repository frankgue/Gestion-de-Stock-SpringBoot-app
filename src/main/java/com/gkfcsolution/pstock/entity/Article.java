package com.gkfcsolution.pstock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2025 at 14:53
 * File: null.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 14:53
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private String libelle;
    private float pa;
    private int tva;
    private int fodec;
    private float pv;
    private float stockInit;
    private float stock;
}
