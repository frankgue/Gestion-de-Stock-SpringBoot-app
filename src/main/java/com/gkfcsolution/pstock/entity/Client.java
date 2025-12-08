package com.gkfcsolution.pstock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2025 at 14:17
 * File: null.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 14:17
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private String code;
    private String libelle;
//    private String contact;
    private String adresse;
    private String tel;
    private String fax;
    private String email;
//    private String matfisc;
//    private String asuj;
//    private String timbre;
//    private float soldeInit;
//    private float solde;
    private String login;
    private String pwd;
}
