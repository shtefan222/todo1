package com.spring.todo1.services;

import com.spring.todo1.models.Article;
import com.spring.todo1.models.ArticleType;
import com.spring.todo1.models.Task;
import com.spring.todo1.repositories.ArticleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService{
    private final ArticleRepository articleRepository;

    @Autowired
    private EntityManager entityManager;
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
    @Transactional
    public Article createArticleNative(Article article) {
        String query = "INSERT INTO article (article_title, article_link, article_type, date) VALUES (:title, :link, :type, :date)";

        ArticleType type = article.getArticleType();
        int articleTypeId = type.ordinal(); // Assuming ordinal represents the type ID

        Query nativeQuery = entityManager.createNativeQuery(query, Article.class);
        nativeQuery.setParameter("title", article.getArticleTitle());
        nativeQuery.setParameter("link", article.getArticleLink());
        nativeQuery.setParameter("type", articleTypeId); // Set the type ID
        nativeQuery.setParameter("date", article.getDate());

        // Execute the update and retrieve the generated ID
        int rowsAffected = nativeQuery.executeUpdate();

        if (rowsAffected == 1) {
            // Successfully inserted article, retrieve it using generated ID
            Long generatedId = (Long) nativeQuery.getSingleResult();
            return entityManager.find(Article.class, generatedId);
        } else {
            // Handle potential errors (e.g., constraint violations)
            throw new RuntimeException("Failed to create article. Please check the input data and database constraints.");
        }
    }

    @Override
    public Iterable<Article> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public void deleteArticleById(Long id) {
        articleRepository.deleteById(id);

    }
    @Override
    @Transactional
    public void deleteArticleByIdNative(Long id) {
        String query = "DELETE FROM article WHERE id = :id";
        Query nativeQuery = entityManager.createNativeQuery(query);
        nativeQuery.setParameter("id", id);
        nativeQuery.executeUpdate();
    }
    @Override
    @Transactional
    public Article getArticleByIdNative(Long id) {
        String query = "SELECT * FROM article WHERE id = :id";
        Query nativeQuery = entityManager.createNativeQuery(query, Article.class);
        nativeQuery.setParameter("id", id);
        return (Article) nativeQuery.getSingleResult();
    }
    @Override
    @Transactional
    public List<Article> getAllArticlesNative() {
        String query = "SELECT * FROM article";
        Query nativeQuery = entityManager.createNativeQuery(query, Article.class);
        return nativeQuery.getResultList();
    }



    @Override
    @Transactional
    public void updateArticleStatuses(List<Long> articleIds, String newStatus) {
        for (Long articleId : articleIds) {
            Article article = articleRepository.findById(articleId).orElse(null);
            if (article != null) {
                article.setStatus(newStatus);
                articleRepository.save(article);
            }
        }
    }



    public List<Article> findArticlesByDateRange(Date startDate, Date endDate) {
        return articleRepository.findArticlesByDateRange(startDate, endDate);
    }
}
