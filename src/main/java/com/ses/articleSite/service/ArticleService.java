package com.ses.articleSite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ses.articleSite.model.Article;
import com.ses.articleSite.repository.ArticleRepository;

@Service
public class ArticleService {
	
	private ArticleRepository articleRepository;
	
	@Autowired
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	
	public List<Article> findAll(PageRequest pageRequest){
		return articleRepository.findAll(pageRequest).getContent();
	}
	
}
