package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("logout.kosa")
public class LogOutController {
	
	@RequestMapping(method=RequestMethod.POST)
	public String out(HttpSession session) {
		session.invalidate();
		return "loginForm";
		
		//return "redirect:loginForm.kosa";
	}
}
