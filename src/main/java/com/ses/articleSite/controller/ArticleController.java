package com.ses.articleSite.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
	
	@GetMapping
	public String ping() {
		return "Service is running...";
	}
	
}
