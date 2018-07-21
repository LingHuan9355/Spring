package com.hr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloAciton implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("sayhello springmvc");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "sayhello springmvc");
		
		mv.setViewName("success");
		return mv;
	}

}
