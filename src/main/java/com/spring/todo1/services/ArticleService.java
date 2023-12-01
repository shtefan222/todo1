package com.spring.todo1.services;

import com.spring.todo1.models.Article;


import java.util.List;


public interface ArticleService {
    public List<Article> getAllArticles();

    public Article getArticleById(Long id);

    public Article createArticle(Article article);

    public void deleteArticleById(Long id) ;
}
