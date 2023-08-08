package edu.kosa.view;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.kosa.dao_di.UserDAO;
import edu.kosa.model.UserVO;

public class MainEntry {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("ctx.xml");
		
		UserDAO  dao = ctx.getBean("dao", UserDAO.class);
		dao.menu();
		Scanner sc = new Scanner(System.in);
		
		switch (sc.nextInt()) {
			case 1:
					UserVO vo = new UserVO();
					System.out.print("user id= ");				vo.setId(sc.next());
					System.out.print("user name= ");			vo.setName(sc.next());
					System.out.print("user pass = ");			vo.setPassword(sc.next());
					
					dao.insert(vo);
					System.out.println(vo.getId() + "추가 성공!!");
					System.out.println("----------------------------");
					break;
					
			case 2:  // selectAll
				dao.selectAll();
				break;
				
			case 3:  // deleteById 
	
				break;
			default:
				break;
		}
		
		
		/*
		UserDAO dao = new OracleUserDAOImpl();
		Scanner sc = new Scanner(System.in);

		dao.menu();
		switch (sc.nextInt()) {
			case 1:
					UserVO vo = new UserVO();
					System.out.print("user id= ");				vo.setId(sc.next());
					System.out.print("user name= ");			vo.setName(sc.next());
					System.out.print("user pass = ");			vo.setPassword(sc.next());
					
					dao.insert(vo);
					System.out.println(vo.getId() + "추가 성공!!");
					System.out.println("----------------------------");
					break;
					
			case 2:  // selectAll
				dao.selectAll();
				break;
			case 3:
	
				break;
			default:
				break;
		}
		*/
	}
}
