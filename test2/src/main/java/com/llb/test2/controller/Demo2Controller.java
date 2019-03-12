package com.llb.test2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value="/demo2")
public class Demo2Controller {
	
	
	@RequestMapping(value="greet")
	public String Greeting( 
			@RequestParam(value="name",required=false,defaultValue="world") 
			String name,Model model)
	{
		model.addAttribute("name",name);
		return "login/greeting";
	}
	
}
