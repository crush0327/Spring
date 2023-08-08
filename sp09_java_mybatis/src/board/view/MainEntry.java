package board.view;

import java.util.List;
import java.util.Scanner;

import board.controller.BoardDAO;
import board.model.BoardVO;

public class MainEntry {
	public static void main(String[] args) {
		
		BoardDAO  dao = new BoardDAO();
		BoardVO vo= null; 
		List<BoardVO> list  = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("선택 : 1. select 2. update 3. insert 4. delete");
		switch (sc.nextInt()) {
				case 1:  list  =   dao.selectAll();
							for(BoardVO board : list) {
								System.out.println(board);
							}
							break;
		
				case 2:  vo = new BoardVO();
							vo.setContent("내용3");
							vo.setTitle("제목3");
							vo.setWriter("작성자3");
							vo.setSeq(1);
							dao.update(vo);
							
							list =   dao.selectAll();
							for(BoardVO board : list) {
								System.out.println(board);
							}
							break;
							
				case 3 : vo = new BoardVO();
							System.out.print("content, title, writer = ");
							vo.setContent(sc.next());
							vo.setTitle(sc.next());
							vo.setWriter(sc.next());
							dao.insert(vo);
							
							list =   dao.selectAll();
							for(BoardVO board : list) {
								System.out.println(board);
							}
		} //end switch
	}	
	
}
