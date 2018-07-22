package com.hr.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloAciton  {

	@RequestMapping("/sayCarl")
	public String sayHello() {
		System.out.println("Hello SpringMVC");
		
		return "success";
	}

}
