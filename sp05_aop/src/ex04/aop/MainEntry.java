package ex04.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ex04/aop/appCtx.xml");
		
		IMessageBean msg = context.getBean("messageBeanImpl", IMessageBean.class);
		msg.sayHello();
		System.out.println("==============================");
		msg.engHello();
		
		System.out.println("==============================");
		IBookBean book = (IBookBean) context.getBean("bookBeanImpl");
		book.testHello("daebo",2);
		System.out.println();
		
		book.korHello(777);
	}
	
}
