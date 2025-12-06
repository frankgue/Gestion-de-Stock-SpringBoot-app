package com.gkfcsolution.pstock.service.impl;

import com.gkfcsolution.pstock.entity.Category;
import com.gkfcsolution.pstock.entity.Fournisseur;
import com.gkfcsolution.pstock.exceptions.ResourceNotFound;
import com.gkfcsolution.pstock.repository.FournisseurRepository;
import com.gkfcsolution.pstock.service.FournisseurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

/**
 * Created on 2025 at 18:58
 * File: FournisseurServiceImpl.java.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 18:58
 */
@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    private FournisseurRepository repository;
    @Override
    public Fournisseur createFournisseur(Fournisseur fournisseur) {
        return repository.save(fournisseur);
    }

    @Override
    public Fournisseur updateFournisseur(Long fournisseurId, Fournisseur fournisseur) throws ResourceNotFound {
        log.info("Update Fournisseur with ID = " + fournisseurId + "....");

        Optional<Fournisseur> fournisseurInfo = repository.findById(fournisseurId);
        if (fournisseurInfo.isPresent()){
            Fournisseur fournisseurResult = fournisseurInfo.get();
            fournisseurResult.setLibelle(fournisseur.getLibelle());
            fournisseurResult.setCode(fournisseur.getCode());
            fournisseurResult.setAsuj(fournisseur.getAsuj());
            fournisseurResult.setEmail(fournisseur.getEmail());
            fournisseurResult.setAdresse(fournisseur.getAdresse());
            fournisseurResult.setContact(fournisseur.getContact());
            fournisseurResult.setMatfisc(fournisseur.getMatfisc());
            fournisseurResult.setSoldeInit(fournisseur.getSoldeInit());
            fournisseurResult.setTel(fournisseur.getTel());
            fournisseurResult.setPwd(fournisseur.getPwd());
            fournisseurResult.setTimbre(fournisseur.getTimbre());
            fournisseurResult.setSolde(fournisseur.getSolde());

            return repository.save(fournisseurResult);

        } else {
            throw  new ResourceNotFound("Fournisseur not found");
        }
    }

    @Override
    public Fournisseur getFournisseur(Long fournisseurId) {
        return repository.findById(fournisseurId).orElseThrow(() -> new RuntimeException("Fournisseur not found"));
    }

    @Override
    public List<Fournisseur> getAllFournisseurs() {
        return repository.findAll();
    }

    @Override
    public void deleteFournisseur(Long fournisseurId) {
        Fournisseur fournisseur = repository.findById(fournisseurId).orElseThrow(() -> new ResolutionException("Fournisseur not found"));
        repository.delete(fournisseur);
    }

    @Override
    public void deleteAllFournisseurs() {
        repository.deleteAll();
    }
}
