package com.restexample.restspringboot.root;

 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class Root {

	@RequestMapping("/startup")
	public ModelAndView landingPage(){
		return new ModelAndView("redirect:/students");
		
	}
	
}
