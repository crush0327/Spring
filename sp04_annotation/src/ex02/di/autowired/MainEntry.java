package ex02.di.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {

		ApplicationContext ctx = new GenericXmlApplicationContext("ex02/di/autowired/autowiredCtx.xml");

		MoniterViewer viewer = ctx.getBean("moniterViewer",MoniterViewer.class);
		viewer.print();
	}
}
