package com.mysite.sbb.Reply.controller;

import com.mysite.sbb.Article.domain.Article;
import com.mysite.sbb.Article.service.ArticleService;
import com.mysite.sbb.Reply.dao.ReplyRepository;
import com.mysite.sbb.Reply.domain.Reply;
import com.mysite.sbb.Reply.reply.ReplyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reply")
@AllArgsConstructor
public class ReplyController {

  private final ArticleService articleService;
  private final ReplyService replyService;

  @PostMapping("/create/{id}")
  public String createReply(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
    Article article = this.articleService.getArticle(id);

    // 질문만들기
    this.replyService.create(article, content);
    return String.format("redirect:/article/detail/%s", id);
  }
  @PostMapping("/like/{articleId}/{replyId}")
  public String createReply(@PathVariable("articleId") Integer articleId, @PathVariable("replyId") Integer replyId) {
    this.replyService.setLike(replyId);


    return String.format("redirect:/article/detail/%s", articleId);
  }
}




