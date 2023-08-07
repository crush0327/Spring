package com.kosa.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosa.dao.BoardDAO;
import com.kosa.model.BoardVO;

@WebServlet("/board")
public class BoardController extends HttpServlet {

	public BoardController() {
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = request.getParameter("cmd"); // ~~/board?cmd=list
		// System.out.println("cmd : " + cmd);

		if (cmd.equals("list")) {
			list(request, response);
		} else if (cmd.equals("write")) {
			write(request, response);
		} else if (cmd.equals("detail")) {
			detail(request, response);
		} else if (cmd.equals("update")) {
			update(request, response);
		} else if (cmd.equals("search")) {
			search(request, response);
		} else if (cmd.equals("search2")) {
			search2(request, response);
		} else if (cmd.equals("delete")) {
			delete(request, response);
		}

	} // service end

	// delete 
	public void delete(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String seq = request.getParameter("seq");
		BoardDAO dao = new BoardDAO();
		int rowcount = dao.delete(Integer.parseInt(seq));
		if( rowcount > 0 ) {
			list(request, response);   // response.sendRedirect("board?cmd=list");
		} 
	} // delete end

	// search 
	public  void search(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String column = request.getParameter("column");
		String keyvalue = request.getParameter("keyvalue");
		
		System.out.println(column + ", " + keyvalue);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("keyvalue", keyvalue);
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectSearchList(map);
		
		if( list != null ) {
			request.setAttribute("list", list); // data save
			request.getRequestDispatcher("/views/searchList.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/error.jsp");
		}
	}
	
	public  void search2(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String writer = request.getParameter("writer");
		String content = request.getParameter("contnet");
		String title = request.getParameter("title");
		String keyvalue = request.getParameter("keyvalue");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("title", title);
		map.put("content", content);
		map.put("writer", writer);
		map.put("keyvalue", keyvalue);
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectSearchList2(map);
		
		if( list != null ) {
			request.setAttribute("list", list); // data save
			request.getRequestDispatcher("/views/searchList.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/error.jsp");
		}
		
	}

	// update page
	private void update(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		String seq = request.getParameter("seq");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO(title, writer, content);
		vo.setSeq(Integer.parseInt(seq));

		int count = dao.update(vo);
		if (count > 0) {
			// response.sendRedirect("board?cmd=list");
			list(request, response);
		}
	}

	// detail page
	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String seq = request.getParameter("seq");
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.detailList(Integer.parseInt(seq));

		if (vo != null) {
			request.setAttribute("dto", vo);
			request.getRequestDispatcher("views/detail.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/error.jsp");
		}
	}

	public void write(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		// System.out.println(title + ",\t" + writer + ",\t" + content);

		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO(title, writer, content);

		int rowcount = dao.insert(vo); // db insert 처리

		if (rowcount > 0) {
			response.sendRedirect("board?cmd=list");
		} else {
			response.sendRedirect("views/error.jsp");
		}
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectAll();

		if (!list.isEmpty()) {
			request.setAttribute("list", list); // data save
			request.getRequestDispatcher("views/list.jsp").forward(request, response);
		} else {
			// response.sendRedirect("index.html");
			response.sendRedirect("views/error.jsp");
		}
	}

}
