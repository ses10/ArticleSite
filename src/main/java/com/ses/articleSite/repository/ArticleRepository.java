package com.ses.articleSite.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ses.articleSite.model.Article;

public interface ArticleRepository extends MongoRepository<Article, String>{

}
