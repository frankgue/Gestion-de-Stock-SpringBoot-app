package com.gkfcsolution.pstock.controller;

import com.gkfcsolution.pstock.entity.Article;
import com.gkfcsolution.pstock.entity.Fournisseur;
import com.gkfcsolution.pstock.exceptions.ResourceNotFound;
import com.gkfcsolution.pstock.repository.FournisseurRepository;
import com.gkfcsolution.pstock.service.FournisseurService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.*;

/**
 * Created on 2025 at 15:22
 * File: null.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 15:22
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Slf4j
public class FournisseurController {

    @Autowired
    private FournisseurService service;

    @GetMapping("/fournisseurs")
    public List<Fournisseur> getAllFournisseurs() {
        log.info("Get all Fournisseurs ...");
        return service.getAllFournisseurs();
    }

    @GetMapping("/fournisseurs/{id}")
    public ResponseEntity<Fournisseur> getFournisseur(@PathVariable(value = "id") Long fournisseurId){
        Fournisseur fournisseur = service.getFournisseur(fournisseurId);
        return ResponseEntity.ok().body(fournisseur);
    }

    @PostMapping("/fournisseurs")
    public Fournisseur createFournisseur(@Valid @RequestBody Fournisseur fournisseur){
        return service.createFournisseur(fournisseur);
    }

    @DeleteMapping("/fournisseurs/{id}")
    public Map<String, Boolean> deleteFournisseur(@PathVariable(value = "id") Long fournisseurId) throws ResourceNotFound {
        service.deleteFournisseur(fournisseurId);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("deleted", Boolean.TRUE);
        return reponse;
    }

    @DeleteMapping("/fournisseurs/delete")
    public ResponseEntity<String> deleteAllFournisseurs() throws ResourceNotFound{
        service.deleteAllFournisseurs();
        return new ResponseEntity<>("All Fournisseurs have been deleted!", HttpStatus.OK);
    }

    @PutMapping("/fournisseurs/{id}")
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable("id") Long fournisseurId, @Valid @RequestBody Fournisseur fournisseur) throws ResourceNotFound {
        log.info("Update Fournisseur with ID = " + fournisseurId + "....");

        Fournisseur updateFournisseur = service.updateFournisseur(fournisseurId, fournisseur);
        if (updateFournisseur != null){
            return new ResponseEntity<>(updateFournisseur, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
