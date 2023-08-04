package edu.kosa.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.kosa.model.DeptDAO;

@Controller
public class ListController {

	@Autowired
	private DeptDAO deptDao;
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		
		List list = deptDao.listDept();
		
		model.addAttribute("list", list);
		return "list"; //	/WEB-INF/views/list.jsp
	}
	
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("greeting", getGreeting());
		mav.setViewName("hello");
		
		return mav;
		
	}

	private Object getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		if( hour >= 6 && hour <= 11) {
			return "Good Moring";
		}else if( hour >= 12 && hour <= 15) {
			return "맛점하십쇼";
		}else if( hour >= 18 && hour <= 20) {
			return "퇴근하십쇼";
		}
		return "Hello World";
	}
	
}
