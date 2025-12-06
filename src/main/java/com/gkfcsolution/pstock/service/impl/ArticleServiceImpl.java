package com.gkfcsolution.pstock.service.impl;

import com.gkfcsolution.pstock.entity.Article;
import com.gkfcsolution.pstock.exceptions.ResourceNotFound;
import com.gkfcsolution.pstock.repository.ArticleRepository;
import com.gkfcsolution.pstock.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

/**
 * Created on 2025 at 18:37
 * File: ArticleServiceImpl.java.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 18:37
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository repository;
    @Override
    public Article createArticle(Article article) {
        return repository.save(article);
    }

    @Override
    public Article updateArticle(Long articleId, Article article) throws ResourceNotFound {
        log.info("Update Article with ID = " + articleId + "....");

        Optional<Article> articleInfo = repository.findById(articleId);
        if (articleInfo.isPresent()){
            Article articleResult = articleInfo.get();
            articleResult.setCode(article.getCode());
            articleResult.setPv(article.getPv());
            articleResult.setPa(article.getPa());
            articleResult.setFodec(article.getFodec());
            articleResult.setLibelle(article.getLibelle());
            articleResult.setStock(article.getStock());
            articleResult.setTva(article.getTva());
            articleResult.setStockInit(article.getStockInit());


            return repository.save(articleResult);

        } else {
            throw  new ResourceNotFound("Article not found");
        }
    }

    @Override
    public Article getArticle(Long articleId) {
        return repository.findById(articleId).orElseThrow(() -> new RuntimeException("Article not found"));
    }

    @Override
    public List<Article> getAllArticles() {
        return repository.findAll();
    }

    @Override
    public void deleteArticle(Long articleId) {
        Article article = repository.findById(articleId).orElseThrow(() -> new ResolutionException("Article not found"));
        repository.delete(article);
    }

    @Override
    public void deleteAllArticles() {
        repository.deleteAll();
    }
}
