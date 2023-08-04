package edu.kosa.view;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.kosa.dao.di.UserDAO;
import edu.kosa.model.UsersVO;

public class MainEntry {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ctx.xml");
		UserDAO dao = ctx.getBean("dao", UserDAO.class);

		while (true) {
			dao.menu();
			switch (sc.nextInt()) {
			case 1:
				UsersVO vo = new UsersVO();
				System.out.println("user id= ");
				vo.setId(sc.next());
				System.out.println("user name= ");
				vo.setName(sc.next());
				System.out.println("user pass= ");
				vo.setPassword(sc.next());

				dao.insert(vo);
				System.out.println(vo.getId() + "추가 성공!");
				System.out.println("==============================");
				break;
			case 2: // selectAll
				dao.selectAll();
				break;
			case 3:
				System.out.println("user id 입력하세요. ");
				String Id = sc.next();
				dao.selectById(Id);

				break;
			case 4:
				System.out.println("정보 변경을 원하는 user id를 입력하세요. ");
				Id = sc.next();
				dao.update(Id);
				break;
			case 5:
				System.out.println("user id 입력하세요. ");
				Id = sc.next();
				dao.delete(Id);
			case 6:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				;
				break;
			}
		}

		/*
		 * UserDAO dao = new OracleUserDAOImpl(); Scanner sc = new Scanner(System.in);
		 * 
		 * dao.menu(); switch (sc.nextInt()) { case 1: UsersVO vo = new UsersVO();
		 * System.out.println("user id= "); vo.setId(sc.next());
		 * System.out.println("user name= "); vo.setName(sc.next());
		 * System.out.println("user pass= "); vo.setPassword(sc.next());
		 * 
		 * dao.insert(vo); System.out.println(vo.getId()+"추가 성공!");
		 * System.out.println("=============================="); break; case 2:
		 * //selectAll dao.selectAll(); break; case 3:
		 * System.out.println("user id 입력하세요. "); String Id=sc.next();
		 * dao.selectById(Id);
		 * 
		 * break; case 4: //System.out.println("user id 입력하세요. "); Id=sc.next();
		 * //dao.selectById(Id); break; case 5: System.out.println("user id 입력하세요. ");
		 * Id=sc.next(); dao.delete(Id);
		 * 
		 * break; default: break; }
		 */
	}

}
