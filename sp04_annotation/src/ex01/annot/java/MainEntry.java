package ex01.annot.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainEntry {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext  ctx = 
				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Cats castInfo = ctx.getBean("catsInfo", Cats.class);
		castInfo.getMyCatsInfo();
		
		MyCats  cats2 = (MyCats)ctx.getBean("cat2");
		castInfo.setMyCatsInfo(cats2);
		castInfo.getMyCatsInfo();
		
		ctx.close();
	}
}
