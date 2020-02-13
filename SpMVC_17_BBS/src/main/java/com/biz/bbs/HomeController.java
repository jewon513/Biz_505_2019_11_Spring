package com.biz.bbs;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		
		return "join";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write() {
		
		return "write";
	}
	
	@RequestMapping(value = "about", method = RequestMethod.GET)
	public String about() {
		
		return "about";
	}
	
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String view() {
		
		return "view";
	}
	
}
