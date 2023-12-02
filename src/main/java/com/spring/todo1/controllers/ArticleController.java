package com.spring.todo1.controllers;

import com.spring.todo1.models.Article;
import com.spring.todo1.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * Show all articles
     * @return List of all articles
     */
    @GetMapping("/all")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }


    /**
     * Create new article
     * @return new article
     */
    @PostMapping("/create")
    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
        articleService.createArticle(article);
        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }

    /**
     * Show article by id
     * @return article by id
     */
    @GetMapping("/{id}")
    public Article getArticleByID(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }
    /**
     * Delete article by id
     */
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        articleService.deleteArticleById(id);
    }
}
