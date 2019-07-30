package com.ses.articleSite.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ses.articleSite.model.Article;
import com.ses.articleSite.service.ArticleService;

@RunWith(SpringRunner.class)
@WebMvcTest(ArticleController.class)
public class ArticleControllerTest {
	
    @Autowired
    private MockMvc controller;
	
	@MockBean
	private ArticleService articleService;
	
	@Test
	public void GetArticlesShouldReturn200AndJsonArray() throws Exception {
		List<Article> articles = new ArrayList<Article>();
		articles.add(new Article("1", "Bob", "", ""));
		articles.add(new Article("2", "Rob", "", ""));
		articles.add(new Article("3", "Tom", "", ""));
		
		Mockito.when(articleService.findAll(Mockito.isA(PageRequest.class))).thenReturn(articles);
		
		controller.perform(get("/articles?page=0&size=3"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(content().json("[{\"id\":\"1\",\"by\":\"Bob\",\"title\":\"\",\"url\":\"\"},{\"id\":\"2\",\"by\":\"Rob\",\"title\":\"\",\"url\":\"\"},{\"id\":\"3\",\"by\":\"Tom\",\"title\":\"\",\"url\":\"\"}]"))
			.andReturn();
	}
	
	@Test
	public void pingShouldReturn200() throws Exception {
		controller.perform(get("/ping"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Service is running...")));
	}
	
}
