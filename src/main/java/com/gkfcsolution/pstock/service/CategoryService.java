package com.gkfcsolution.pstock.service;

import com.gkfcsolution.pstock.entity.Category;
import com.gkfcsolution.pstock.exceptions.ResourceNotFound;

import java.util.List;

/**
 * Created on 2025 at 18:43
 * File: null.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 18:43
 */
public interface CategoryService {
    Category createCategory(Category category);
    Category updateCategory(Long categoryId,  Category category) throws ResourceNotFound;
    Category getCategory( Long categoryId);
    List<Category> getAllCategories();
    void deleteCategory( Long categoryId);
    void deleteAllCategories();
}
