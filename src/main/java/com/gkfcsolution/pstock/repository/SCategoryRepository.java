package com.gkfcsolution.pstock.repository;

import com.gkfcsolution.pstock.entity.SCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 2025 at 15:26
 * File: null.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 15:26
 */

public interface SCategoryRepository extends JpaRepository<SCategory, Long> {
}
