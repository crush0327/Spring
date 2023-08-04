package ex04.di.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
		String config = "classpath:ex04/di/resource/resourceCtx.xml";
		ApplicationContext ctx = new GenericXmlApplicationContext(config);
		
		MoniterViewer viewer = ctx.getBean("moniterViewer",MoniterViewer.class);
		
	}
}
