package com.gkfcsolution.pstock.service;

import com.gkfcsolution.pstock.entity.SCategory;
import com.gkfcsolution.pstock.exceptions.ResourceNotFound;

import java.util.List;

/**
 * Created on 2025 at 19:10
 * File: null.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 19:10
 */
public interface SCategoryService {
    SCategory createSCategory(SCategory scategory);
    SCategory updateSCategory(Long scategoryId,  SCategory scategory) throws ResourceNotFound;
    SCategory getSCategory( Long scategoryId);
    List<SCategory> getAllSCategories();
    void deleteSCategory( Long scategoryId);
    void deleteAllSCategories();
}
