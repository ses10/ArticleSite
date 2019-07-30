package com.ses.articleSite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ses.articleSite.repository.ArticleRepository;

@RestController
public class ArticleController {
	
	@Autowired
	ArticleRepository repo;
	
	@GetMapping
	public String ping() {
		System.out.println(repo.findAll().size());
		return "Service is running...";
	}
	
}
