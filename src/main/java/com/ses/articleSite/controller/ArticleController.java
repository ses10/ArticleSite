package com.ses.articleSite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ses.articleSite.model.Article;
import com.ses.articleSite.service.ArticleService;

@RestController
public class ArticleController {
	
	private ArticleService articleService;
	
	@Autowired
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@GetMapping(path="ping")
	public String ping() {
		return "Service is running...";
	}
	
	@GetMapping(path="/articles", params = {"page", "size"}, produces = "application/json")
	public List<Article> findArticles(@RequestParam("page") int page, @RequestParam("size") int size) {
		return articleService.findAll(PageRequest.of(page, size));
	}
	
}
