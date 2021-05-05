package com.github.miajrush.university.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller used to show the main page.
 */
@Controller
public class IndexController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
