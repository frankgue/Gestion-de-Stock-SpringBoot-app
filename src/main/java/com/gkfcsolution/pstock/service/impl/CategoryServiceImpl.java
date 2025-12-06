package com.gkfcsolution.pstock.service.impl;

import com.gkfcsolution.pstock.entity.Category;
import com.gkfcsolution.pstock.entity.Client;
import com.gkfcsolution.pstock.exceptions.ResourceNotFound;
import com.gkfcsolution.pstock.repository.CategoryRepository;
import com.gkfcsolution.pstock.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

/**
 * Created on 2025 at 18:45
 * File: CategoryServiceImpl.java.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 18:45
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;
    @Override
    public Category createCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public Category updateCategory(Long categoryId, Category category) throws ResourceNotFound {
        log.info("Update Category with ID = " + categoryId + "....");

        Optional<Category> categoryInfo = repository.findById(categoryId);
        if (categoryInfo.isPresent()){
            Category categoryResult = categoryInfo.get();
            categoryResult.setCode(category.getCode());
            categoryResult.setLibelle(category.getLibelle());

            return repository.save(categoryResult);

        } else {
            throw  new ResourceNotFound("Client not found");
        }
    }

    @Override
    public Category getCategory(Long categoryId) {
        return repository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = repository.findById(categoryId).orElseThrow(() -> new ResolutionException("Category not found"));
        repository.delete(category);
    }

    @Override
    public void deleteAllCategories() {
        repository.deleteAll();
    }
}
