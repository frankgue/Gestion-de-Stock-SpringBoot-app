package com.gkfcsolution.pstock.service.impl;

import com.gkfcsolution.pstock.entity.Fournisseur;
import com.gkfcsolution.pstock.entity.SCategory;
import com.gkfcsolution.pstock.exceptions.ResourceNotFound;
import com.gkfcsolution.pstock.repository.SCategoryRepository;
import com.gkfcsolution.pstock.service.SCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

/**
 * Created on 2025 at 19:12
 * File: SCategoryServiceImpl.java.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 19:12
 */
@Service
@Slf4j
public class SCategoryServiceImpl implements SCategoryService {

    @Autowired
    private SCategoryRepository repository;
    @Override
    public SCategory createSCategory(SCategory scategory) {
        return repository.save(scategory);
    }

    @Override
    public SCategory updateSCategory(Long scategoryId, SCategory scategory) throws ResourceNotFound {
        log.info("Update SCategory with ID = " + scategoryId + "....");

        Optional<SCategory> scategoryInfo = repository.findById(scategoryId);
        if (scategoryInfo.isPresent()){
            SCategory sCategoryResult = scategoryInfo.get();
            sCategoryResult.setCode(scategory.getCode());
            sCategoryResult.setCode_categ(scategory.getCode_categ());
            sCategoryResult.setLibelle(scategory.getLibelle());

            return repository.save(sCategoryResult);

        } else {
            throw  new ResourceNotFound("SCategory not found");
        }
    }

    @Override
    public SCategory getSCategory(Long scategoryId) {
        return repository.findById(scategoryId).orElseThrow(() -> new RuntimeException("SCategory not found"));
    }

    @Override
    public List<SCategory> getAllSCategories() {
        return repository.findAll();
    }

    @Override
    public void deleteSCategory(Long scategoryId) {
        SCategory sCategory = repository.findById(scategoryId).orElseThrow(() -> new ResolutionException("SCategory not found"));
        repository.delete(sCategory);
    }

    @Override
    public void deleteAllSCategories() {
        repository.deleteAll();
    }
}
