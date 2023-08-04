package ex01.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ex01/di/playerCtx.xml");
		
		PlayerImpl p = ctx.getBean("player",PlayerImpl.class);
		PlayerImpl p2 = ctx.getBean("player2",PlayerImpl.class);
		
		
		//String[] sportsName = {"축구", "농구","컬링"};
		Object[] className = {ctx.getBean("soccer"),ctx.getBean("basketball"),ctx.getBean("curling")};
		
//		for (int i = 0; i < sportsName.length; i++) {
//			System.out.println("<"+sportsName[i]+">");
//			p.input();
//			p.info();			
//			System.out.println();
//		}
		
		for (int i = 0; i < className.length; i++) {
			System.out.println(className[i]);
			p.setName("aa");
			p.setPosition("bb");
			p.setSport("cc");
			p.info();
		}
		
	}
}
