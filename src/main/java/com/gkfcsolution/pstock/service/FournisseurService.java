package com.gkfcsolution.pstock.service;

import com.gkfcsolution.pstock.entity.Fournisseur;
import com.gkfcsolution.pstock.exceptions.ResourceNotFound;

import java.util.List;

/**
 * Created on 2025 at 18:57
 * File: null.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 18:57
 */
public interface FournisseurService {
    Fournisseur createFournisseur(Fournisseur fournisseur);
    Fournisseur updateFournisseur(Long fournisseurId,  Fournisseur fournisseur) throws ResourceNotFound;
    Fournisseur getFournisseur( Long fournisseurId);
    List<Fournisseur> getAllFournisseurs();
    void deleteFournisseur( Long fournisseurId);
    void deleteAllFournisseurs();
}
