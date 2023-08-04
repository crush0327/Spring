package kr.co.mycom.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mycom.model.BoardDTO;
import kr.co.mycom.service.BoardService;

@Controller
public class BoardController {
	
	@Resource
	private BoardService  boardService;  // db 연결 및 DML 명령처리
	
	@RequestMapping("/writeform.htm")    // GET 전송방식 처리
	public String writeform() {
		return "writeform";      //   /WEB-INF/views/+writeform+.jsp
	}
	
	@RequestMapping("/write.htm")
	public String write(BoardDTO dto) {
		boardService.insertBoard(dto);
		return "redirect:/list.htm";   
	}
	
	@RequestMapping("/list.htm")
	public String list(HttpServletRequest request) {
		
		int pg = 1;
		String strPg = request.getParameter("pg");
		
		if( strPg != null ) {
			pg = Integer.parseInt(strPg);
		}
		
		int rowSize = 5;
		int start = (pg * rowSize)-(rowSize - 1);    
		int end = pg*rowSize;
		
		int total = boardService.getBoardCount();  // 총 게시물 수?
		System.out.println(start + ", " + end + ", " + total);
		
		int allPage = (int)Math.ceil(total / (double)rowSize);  // 페이지수
		System.out.println("전체 페이지수 : " +  allPage );
		
		int block = 10;  // 한페이지에 보여줄 범위  <<[1][2][3]~~[8][9][10] >>
		int formPage = ( (pg -1) / block*block ) + 1;  // 보여줄 페이지의 시작
		int toPage = ( (pg-1) / block*block ) + block;  // 보여줄 페이지의 끝
		
		if( toPage > allPage ) {   // 20 > 17
			toPage = allPage;
		}
		
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<BoardDTO> list = boardService.getBoardList(map);
		request.setAttribute("list", list);
		request.setAttribute("pg", pg);
		request.setAttribute("allPage", allPage);
		request.setAttribute("formPage", formPage);
		request.setAttribute("toPage", toPage);
		request.setAttribute("block", block);
				
		return "list";   // list.jsp
	}
}












