package com.ses.articleSite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontEndController {
	
	@GetMapping("/")
	public String main() {
		return "index";
	}
	
}
