package com.ses.articleSite.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ses.articleSite.model.Article;

public interface ArticleRepository extends MongoRepository<Article, String>{
	
	Page<Article> findAll(Pageable pageable);
	
}
