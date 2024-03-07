package com.spring.todo1.controllers;

import com.spring.todo1.models.Article;
import com.spring.todo1.models.UpdateStatusRequest;
import com.spring.todo1.services.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
//@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    //@Autowired
//    public ArticleController(ArticleService articleService) {
//        this.articleService = articleService;
//    }

    /**
     *Retrieves all articles from the database using the ArticleService and adds them to the ModelAndView.
     *  * The ModelAndView is then returned to render the 'articles' template, passing the articles data to the view.
     * @return ModelAndView object containing the 'articles' template
     * and the list of articles retrieved from the database
     */
    @GetMapping("/articles")
    public ModelAndView articles() {
        ModelAndView modelAndView = new ModelAndView("articles");
        modelAndView.addObject("articles", articleService.getAll());
        return modelAndView;
    }

    @PostMapping("/addArticle")
    public String addArticle(@ModelAttribute("newArticle") Article newArticle) {
        articleService.createArticle(newArticle);
        log.info("addArticle {}", newArticle);
    return "redirect:/articles";
    }
//
    /**
     * Show all articles
     * @return List of all articles
     */

    @GetMapping("/articles/all")
    @ResponseBody
    public List<Article> getAllArticles() {
        log.info("Get all articles");
        return articleService.getAllArticlesNative();
    }
//
//
    /**
     * Create new article
     * @return new article
     */
    @PostMapping("/articles/create")
    //@ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Article addArticlePost(@RequestBody Article article) {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId systemZone = ZoneId.systemDefault();
        Date date = Date.from(localDateTime.atZone(systemZone).toInstant());
        article.setDate(date);
        articleService.createArticleNative(article);
        log.info("addArticle {}", article);

        return article;
    }
//
    /**
     * Show article by id
     * @return article by id
     */
    @GetMapping("articles/{id}")
    @ResponseBody
    public Article getArticleByID(@PathVariable Long id) {
        log.info("Delete article with id {}", id);
        return articleService.getArticleById(id);
    }

    @PostMapping("/updateArticleStatuses")
    @ResponseBody
    public void updateArticleStatuses(@RequestBody UpdateStatusRequest request) {
        List<Long> articleIds = request.getArticleIds();
        String newStatus = request.getNewStatus();
        articleService.updateArticleStatuses(articleIds, newStatus);
    }

    @GetMapping("/articlesByDate")
    public List<Article> getArticlesByDateRange(@RequestParam("start") String start,
                                                @RequestParam("end") String end) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = formatter.parse(start);
        Date endDate = formatter.parse(end);
        return articleService.findArticlesByDateRange(startDate, endDate);
    }


    /**
     * Delete article by id
//     */
//    @DeleteMapping("/delete/{id}")
//    public void deleteById(@PathVariable Long id) {
//        articleService.deleteArticleByIdNative(id);
//    }
}