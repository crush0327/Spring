package board.view;

import java.util.List;
import java.util.Scanner;

import board.controller.BoardDAO;
import board.model.BoardVO;

public class MainEntry {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();


		while (true) {
			Scanner sc = new Scanner(System.in);

			System.out.println("****************메인메뉴****************");
			System.out.println("\n원하는 메뉴를 번호로 입력하시오");
			System.out.println("1.select 2.insert 3.update 4.delete 5.종료");

			switch (sc.nextInt()) {

			case 1:
				List<BoardVO> list = dao.selectAll();
				for (BoardVO board : list) {
					System.out.println(board);
				}

				break;
			case 2:
				System.out.println("원하는 제목을 입력하세요");
				String title= sc.next();
				System.out.println("원하는 내용을 입력하세요");
				String content = sc.next();
				System.out.println("원하는 작성자를 입력하세요");
				String writer = sc.next();
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				dao.insert(vo);

				break;
			case 3:
				list = dao.selectAll();
				for (BoardVO board : list) {
					System.out.println(board);
				}
				System.out.println("변경을 원하는 번호를 입력하세요");
				int seq = sc.nextInt();
				vo.setSeq(seq);
				
				System.out.println("제목을 입력하세요.");
				vo.setTitle(sc.next());
				System.out.println("내용을 입력하세요.");
				vo.setContent(sc.next());
				System.out.println("작성자을 입력하세요.");
				vo.setWriter(sc.next());

				dao.update(vo);

				break;
			case 4:
				list = dao.selectAll();
				for (BoardVO board : list) {
					System.out.println(board);
				}
				System.out.println("삭제를 원하는 번호를 입력하시오");
				seq = sc.nextInt();
				dao.delete(seq);
				break;

			case 5:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}
		}
	}

}
