package kr.edu.kosa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoController  {

	@RequestMapping("/info")
	public String info(Model model) {
		String phone = "010-9872-0202";
		
		model.addAttribute("name", "¿Ãµµø¨");
		model.addAttribute("phone", phone);
		
		//return  "/WEB-INF/views/info.jsp"; 
		return "info";
	}
}
