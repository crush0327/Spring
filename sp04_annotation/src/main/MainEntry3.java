package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import springConfig.Client;

public class MainEntry3 {
	public static void main(String[] args) {
		String config = "classpath:springConfig/clientCtx.xml";
		ClassPathXmlApplicationContext ctx  = new ClassPathXmlApplicationContext(config);
		Client c = ctx.getBean("client",Client.class);
		c.setHost("server!!!");
		c.send();
		
		Client c2=ctx.getBean("client",Client.class);
		c.setHost("defaultHost");
		c.send();
		//JavaConfig jconfig = ctx.getBean("client",JavaConfig.class);
	}
}
