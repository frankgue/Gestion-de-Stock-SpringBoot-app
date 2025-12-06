package com.gkfcsolution.pstock.controller;

import com.gkfcsolution.pstock.entity.Article;
import com.gkfcsolution.pstock.exceptions.ResourceNotFound;
import com.gkfcsolution.pstock.repository.ArticleRepository;
import com.gkfcsolution.pstock.service.ArticleService;
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
public class ArticleController {

    @Autowired
    private ArticleService service;

    @GetMapping("/articles")
    public List<Article> getAllArticles() {
      log.info("Get all Articles ...");
        return service.getAllArticles();
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable(value = "id") Long articleId){
        Article article = service.getArticle(articleId);
        return ResponseEntity.ok().body(article);
    }

    @PostMapping("/articles")
    public Article createArticle(@Valid @RequestBody Article article){
        return service.createArticle(article);
    }

    @DeleteMapping("/articles/{id}")
    public Map<String, Boolean> deleteArticle(@PathVariable(value = "id") Long articleId) throws ResourceNotFound{
        service.deleteArticle(articleId);
    Map<String, Boolean> reponse = new HashMap<>();
    reponse.put("deleted", Boolean.TRUE);
    return reponse;
    }

    @DeleteMapping("/articles/delete")
    public ResponseEntity<String> deleteAllArticles(@PathVariable(value = "id") Long articleId) throws ResourceNotFound{
    service.deleteAllArticles();
    return new ResponseEntity<>("All Articles have been deleted!", HttpStatus.OK);
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") Long articleId, @Valid @RequestBody Article article) throws ResourceNotFound {
        log.info("Update Article with ID = " + articleId + "....");
        Article updateArticle = service.updateArticle(articleId, article);
        if (updateArticle != null){
                       return new ResponseEntity<>(updateArticle, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
