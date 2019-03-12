package com.llb.test2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.llb.test2.domain.LoginForm;

@Controller
public class LoginController {
	@RequestMapping(value="login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response,LoginForm command)
	{
		String username=command.getUsername();
		ModelAndView mView=new ModelAndView("login/index","command","LOGIN SUCCESS,"+username);
		return mView;
	}
	
	@RequestMapping(value="greeting")
	public ModelAndView greeting(HttpServletRequest request,HttpServletResponse response,LoginForm command)
	{
		String username=command.getUsername();
		ModelAndView mView=new ModelAndView("login/greeting","command","LOGIN SUCCESS,"+username);
		return mView;
	}
	
	
}
