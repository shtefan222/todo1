package com.spring.todo1.controllers;

import com.spring.todo1.models.Article;
import com.spring.todo1.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/all")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @PostMapping("/create")
    public Article createArticle(Article article) {
        return articleService.createArticle(article);
    }

    @GetMapping("/{id}")
    public Article getArticleByID(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        articleService.deleteArticleById(id);
    }
}
