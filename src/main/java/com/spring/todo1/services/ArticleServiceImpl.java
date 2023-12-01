package com.spring.todo1.services;

import com.spring.todo1.models.Article;
import com.spring.todo1.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService{
    private final ArticleRepository articleRepository;
    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);

    }

    @Override
    public void deleteArticleById(Long id) {
        articleRepository.deleteById(id);

    }
}
