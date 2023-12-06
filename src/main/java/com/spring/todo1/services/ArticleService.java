package com.spring.todo1.services;

import com.spring.todo1.models.Article;
import com.spring.todo1.models.Task;


import java.util.List;


public interface ArticleService {
    List<Article> getAllArticles();

    Article getArticleById(Long id);

    Article createArticle(Article article);

    public Iterable<Article> getAll();

    void deleteArticleById(Long id) ;
}
