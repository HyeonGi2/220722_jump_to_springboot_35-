package com.mysite.sbb.Article.controller;

import com.mysite.sbb.Article.dao.ArticleRepository;
import com.mysite.sbb.Article.domain.Article;
import com.mysite.sbb.Article.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/article")

@AllArgsConstructor

public class ArticleController {

  @Autowired
  private ArticleService articleService;



  @RequestMapping("/list")
  public String showArticles(Model model) {
    List <Article> articleList = articleService.getList();

    model.addAttribute("articleList", articleList);

    return "article_list";

  }
  @RequestMapping("/detail/{id}")
  public String showArticles(Model model,@PathVariable("id") Integer id) {
    Article article = this.articleService.getArticle(id);
     model.addAttribute("article", article);


    return "article_detail";

  }
}
