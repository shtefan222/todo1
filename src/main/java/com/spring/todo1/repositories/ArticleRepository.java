package com.spring.todo1.repositories;

import com.spring.todo1.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("SELECT a FROM Article a WHERE a.date BETWEEN ?1 AND ?2")
    List<Article> findArticlesByDateRange(Date startDate, Date endDate);
}
