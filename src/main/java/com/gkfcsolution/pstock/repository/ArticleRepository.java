package com.gkfcsolution.pstock.repository;

import com.gkfcsolution.pstock.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2025 at 15:29
 * File: null.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 15:29
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
