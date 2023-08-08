package com.practice.security.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.security.model.dao.UserDAO;
import com.practice.security.model.dto.UserDTO;
import com.practice.security.service.ShaEncoder;


@Controller
public class UserController {

	@Autowired
	ShaEncoder shaEncoder;   // �븫�샇�솕 鍮�
	
	@Inject
	UserDAO userDAO;
	
	// 로그인 페이지
	@RequestMapping("/user/login.do")
	public String login() {
		return "user/login";    //  user/login.jsp
	}
	
	// 회원가입 페이지
	@RequestMapping("/user/join.do")
	public String join() {
		return "user/join";    //  user/join.jsp
	}
	
	//회원가입 처리
	@RequestMapping("/user/insertUser.do")
	public String insertUser(@RequestParam  String userid,
						@RequestParam String password,
						@RequestParam String name) {
		// 비밀번호 암호화
		String dbpw = shaEncoder.saltEncoding(password, userid);
		Map<String, String> map = new HashMap();
		map.put("userid", userid);
		map.put("passwd", dbpw);
		map.put("name", name);
		map.put("authority", "ROLE_USER");

		int result = userDAO.insertUser(map);
	
		return "user/login";    
	}

	//홈 영역
	@RequestMapping("/home.do")
	public String home() {
		return "home";
	}
	
	//관리자 영역
	@RequestMapping("/admin/main.do")
	public void adminPage(HttpServletRequest request, 
			HttpServletResponse response,	Authentication auth) throws ServletException, IOException {
		UserDTO dto=(UserDTO)auth.getPrincipal();
		String name = auth.getName();
		request.setAttribute("name", name);
		request.getRequestDispatcher("/WEB-INF/views/admin/main.jsp").forward(request, response);
		return;
	}
	
	//직원 메인
	@RequestMapping("/user/userMain.do")
	public String userPage() {
		return"user/userMain";
	}

	//업데이트 Form
	@RequestMapping("/user/updateMyForm.do")
	public void updateMyForm(HttpServletRequest request, 
			HttpServletResponse response, Authentication auth) throws ServletException, IOException {
		User dto=(User)auth.getPrincipal();
		String id = dto.getUsername();
		
		Map<String, Object> map = userDAO.selectById(id);
		System.out.println(map);
		System.out.println(map.get("ID"));
		System.out.println(map.get("NAME"));
		System.out.println(map.get("ROLE"));
		System.out.println(map.get("REGDATE"));
		request.setAttribute("map", map); // data save
		request.getRequestDispatcher("/WEB-INF/views/user/updateForm.jsp").forward(request, response);
		return;
	}
	
	//업데이트 처리(이름 변경)
	@RequestMapping("/user/update.do")
	public void update(@RequestParam  String id,
			@RequestParam String name, HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{
		Map<String, Object> map = new HashMap();
		map.put("name",name);
		map.put("id",id);
		userDAO.updateUser(map);
		map = userDAO.selectById(id);
		request.setAttribute("map", map); // data save
		request.getRequestDispatcher("/WEB-INF/views/user/updateForm.jsp").forward(request, response);
		return;
	}
	
	@RequestMapping("/user/delete.do")
	public void delete() {
		
	}
	
	@RequestMapping("/admin/list.do")
	public void selectAll(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		List<UserDTO> list = userDAO.selectAll();
		request.setAttribute("list", list); // data save
		request.getRequestDispatcher("/WEB-INF/views/user/updateForm.jsp").forward(request, response);
		return;
	}
}
