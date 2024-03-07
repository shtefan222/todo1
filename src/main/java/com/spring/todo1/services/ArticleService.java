package com.spring.todo1.services;

import com.spring.todo1.models.Article;
import com.spring.todo1.models.Task;


import java.util.Date;
import java.util.List;


public interface ArticleService {
    List<Article> getAllArticles();

    Article getArticleById(Long id);

    Article createArticle(Article article);

    public Iterable<Article> getAll();

    void deleteArticleById(Long id) ;
    public void updateArticleStatuses(List<Long> articleIds, String newStatus );

    public Article getArticleByIdNative(Long id);

    public List<Article> getAllArticlesNative();

    public void deleteArticleByIdNative(Long id);

    public Article createArticleNative(Article article);


    public List<Article> findArticlesByDateRange(Date startDate, Date endDate);
}
