package edu.kosa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WriteFormController {

	@RequestMapping("/writeform.do")
	public String write(Model model, HttpServletRequest request) {
		
		
		return "writeform";
	}
}
