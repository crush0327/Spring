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

		response.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd"); // ~~~~~? cmd=list
		System.out.println("cmd: " + cmd);

		if (cmd.equals("list")) {
			list(request, response);
		} else if (cmd.equals("write")) {
			write(request, response);
		} else if (cmd.equals("writeForm")) {
			request.getRequestDispatcher("/WEB-INF/views/writeForm.jsp").forward(request, response);
		} else if (cmd.equals("delete")) {
			delete(request, response);
		} else if (cmd.equals("detail")) {
			detail(request, response);
		} else if (cmd.equals("update")) {
			update(request, response);
		} else if (cmd.equals("search")) {
			search(request, response);
		} else if (cmd.equals("search2")) {
			search2(request, response);
		}
	} // service end

	// search
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String column = request.getParameter("column");
		String keyvalue = request.getParameter("keyvalue");
		
		if(column.equals("selection")) {
			list(request,response);
			return;
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("keyvalue", keyvalue);

		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectSearchList(map);
		
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
		} else {
			// response.sendRedirect("index.html");
			request.getRequestDispatcher("/WEB-INF/views/error.jsp");
		}

	}

	private void search2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		String keyvalue = request.getParameter("keyvalue");

		Map<String, String> map = new HashMap<String, String>();
		map.put("title", title);
		map.put("content", content);
		map.put("writer", writer);
		map.put("keyvalue", keyvalue);

		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectSearchList2(map);

		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
		} else {
			// response.sendRedirect("index.html");
			request.getRequestDispatcher("/WEB-INF/views/error.jsp");
		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");
		String title = (String) request.getParameter("title");
		String writer = (String) request.getParameter("writer");
		String content = (String) request.getParameter("content");

		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		int num = dao.update(vo);

		if (num > 0) {
			vo = dao.selectBySeq(Integer.parseInt(seq));
			if (vo != null) {
				request.setAttribute("vo", vo);
				request.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(request, response);
			} else {
				// response.sendRedirect("index.html");
				request.getRequestDispatcher("/WEB-INF/views/error.jsp");
			}
		}
	}

	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");
		String readcount =request.getParameter("readcount");
		int num = Integer.parseInt(readcount)+1;
		
		BoardDAO dao = new BoardDAO();
		if (seq != null && readcount != null) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("seq",Integer.parseInt(seq));
			map.put("readcount",num);
			dao.updateReadCount(map);
			BoardVO vo = dao.selectBySeq(Integer.parseInt(seq));
			if (vo != null) {
				request.setAttribute("vo", vo);
				request.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(request, response);
			} else {
				// response.sendRedirect("index.html");
				request.getRequestDispatcher("/WEB-INF/views/error.jsp");
			}
		}

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		BoardDAO dao = new BoardDAO();
		int num = dao.delete(seq);
		if (num > 0)
			list(request, response);
	}

	private void write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = (String) request.getParameter("title");
		String writer = (String) request.getParameter("writer");
		String content = (String) request.getParameter("content");

		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);

		BoardDAO dao = new BoardDAO();
		int num = dao.insert(vo);
		if (num > 0)
			list(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();

		List<BoardVO> list = dao.selectAll();

		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
		} else {
			// response.sendRedirect("index.html");
			request.getRequestDispatcher("/WEB-INF/views/error.jsp");
		}

	}
}
