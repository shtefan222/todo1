package com.spring.todo1.controllers;

import com.spring.todo1.models.Article;
import com.spring.todo1.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("/articles")
    public ModelAndView articles() {
        ModelAndView modelAndView = new ModelAndView("articles");
        modelAndView.addObject("articles", articleService.getAll());
        return modelAndView;
    }

    @PostMapping("/addArticle")
    public String addArticle(@ModelAttribute("newArticle") Article newArticle) {
        articleService.createArticle(newArticle);
        return "redirect:/articles";
    }
//
    /**
     * Show all articles
     * @return List of all articles
     */

//    @GetMapping("/all")
//    @ResponseBody
//    public List<Article> getAllArticles() {
//        return articleService.getAllArticles();
//    }
//
//
//    /**
//     * Create new article
//     * @return new article
//     */
//    @PostMapping("/create")
//    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
//        articleService.createArticle(article);
//        return new ResponseEntity<>(article, HttpStatus.CREATED);
//    }
//
    /**
     * Show article by id
     * @return article by id
     */
    @GetMapping("articles/{id}")
    @ResponseBody
    public Article getArticleByID(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }
//    /**
//     * Delete article by id
//     */
//    @DeleteMapping("/delete/{id}")
//    public void deleteById(@PathVariable Long id) {
//        articleService.deleteArticleById(id);
//    }
}