package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import springConfig.Client2;

public class MainEntry4 {
	public static void main(String[] args) {
		String config = "classpath:springConfig/clientCtx2.xml";
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(config);
		Client2 client = ctx.getBean("client2", Client2.class);
		Client2 client2 = ctx.getBean("client2", Client2.class);
		client.send();
		
		System.out.println(client.hashCode());
		System.out.println(client2.hashCode());
		ctx.close();
	}
}
