package com.gkfcsolution.pstock.controller;

import com.gkfcsolution.pstock.entity.Article;
import com.gkfcsolution.pstock.entity.Category;
import com.gkfcsolution.pstock.exceptions.ResourceNotFound;
import com.gkfcsolution.pstock.repository.CategoryRepository;
import com.gkfcsolution.pstock.service.CategoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.*;

/**
 * Created on 2025 at 15:21
 * File: null.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 15:21
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        log.info("Get all Categories ...");
        return service.getAllCategories();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable(value = "id") Long categoryId){
        Category category = service.getCategory(categoryId);
        return ResponseEntity.ok().body(category);
    }

    @PostMapping("/categories")
    public Category createCategory(@Valid @RequestBody Category category){
        return service.createCategory(category);
    }

    @DeleteMapping("/categories/{id}")
    public Map<String, Boolean> deleteCategory(@PathVariable(value = "id") Long categoryId) throws ResourceNotFound {
        service.deleteCategory(categoryId);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("deleted", Boolean.TRUE);
        return reponse;
    }

    @DeleteMapping("/categories/delete")
    public ResponseEntity<String> deleteAllCategorys() throws ResourceNotFound{
       service.deleteAllCategories();
        return new ResponseEntity<>("All Categories have been deleted!", HttpStatus.OK);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long categoryId, @Valid @RequestBody Category category) throws ResourceNotFound {
        Category updateCategory = service.updateCategory(categoryId, category);
        if (updateCategory != null){

            return new ResponseEntity<>(updateCategory, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
