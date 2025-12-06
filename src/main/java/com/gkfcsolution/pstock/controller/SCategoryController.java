package com.gkfcsolution.pstock.controller;

import com.gkfcsolution.pstock.entity.Fournisseur;
import com.gkfcsolution.pstock.entity.SCategory;
import com.gkfcsolution.pstock.exceptions.ResourceNotFound;
import com.gkfcsolution.pstock.repository.SCategoryRepository;
import com.gkfcsolution.pstock.service.SCategoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.*;

/**
 * Created on 2025 at 18:11
 * File: null.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 18:11
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Slf4j
public class SCategoryController {

    @Autowired
    private SCategoryService service;

    @GetMapping("/scategories")
    public List<SCategory> getAllSCategories() {
        log.info("Get all SCategories ...");
        return service.getAllSCategories();
    }

    @GetMapping("/scategories/{id}")
    public ResponseEntity<SCategory> getSCategory(@PathVariable(value = "id") Long sCategoryId){
        SCategory sCategories = service.getSCategory(sCategoryId);
        return ResponseEntity.ok().body(sCategories);
    }

    @PostMapping("/scategories")
    public SCategory createSCategory(@Valid @RequestBody SCategory sCategory){
        return service.createSCategory(sCategory);
    }

    @DeleteMapping("/scategories/{id}")
    public Map<String, Boolean> deleteSCategory(@PathVariable(value = "id") Long sCategoryId) throws ResourceNotFound {
        service.deleteSCategory(sCategoryId);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("deleted", Boolean.TRUE);
        return reponse;
    }

    @DeleteMapping("/scategories/delete")
    public ResponseEntity<String> deleteAllSCategories() throws ResourceNotFound{
        service.deleteAllSCategories();
        return new ResponseEntity<>("All SCategories have been deleted!", HttpStatus.OK);
    }

    @PutMapping("/scategories/{id}")
    public ResponseEntity<SCategory> updateSCategory(@PathVariable("id") Long sCategoryId, @Valid @RequestBody SCategory sCategory) throws ResourceNotFound {
        log.info("Update SCategory with ID = " + sCategoryId + "....");

        SCategory updateSCategory = service.updateSCategory(sCategoryId, sCategory);
        if (updateSCategory != null){
            return new ResponseEntity<>(updateSCategory, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
