package com.gkfcsolution.pstock.service;

import com.gkfcsolution.pstock.entity.Article;
import com.gkfcsolution.pstock.exceptions.ResourceNotFound;

import java.util.List;

/**
 * Created on 2025 at 18:35
 * File: null.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 18:35
 */
public interface ArticleService {
    Article createArticle(Article article);
    Article updateArticle(Long articleId,  Article article) throws ResourceNotFound;
    Article getArticle( Long articleId);
    List<Article> getAllArticles();
    void deleteArticle( Long articleId);
    void deleteAllArticles();
    
}
