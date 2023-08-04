package quiz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("quiz/appCtx.xml");
		
		IMessageKoImpl helloKo = (IMessageKoImpl)context.getBean("Ko");
		IMessageEngImpl helloEng = (IMessageEngImpl)context.getBean("Eng");
		
		helloKo.sayHello();
		helloEng.sayHello();		
	}
}
