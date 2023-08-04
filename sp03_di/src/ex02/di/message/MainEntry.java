package ex02.di.message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
		ApplicationContext  ctx =                  
				new ClassPathXmlApplicationContext("classpath:ex02/di/message/applicationContext.xml");
		
		MyApplication app = ctx.getBean("myApplication", MyApplication.class);
		app.processMessage("Hi~ Daebo 2기!!", "happy@kosa.or.kr");
		
		
		  MyApplication app2 = ctx.getBean("myApplication", MyApplication.class);
		  System.out.println("app == app2 : " +( app == app2));
		 
	
		MyApplication twitter = ctx.getBean("myApplication2", MyApplication.class);
		twitter.processMessage("Twitter", "https://www.facebook.com/doyeon.lee.58760");
		
		System.out.println("app == twitter : " + (app == twitter) );
	}
}
