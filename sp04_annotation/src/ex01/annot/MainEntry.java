package ex01.annot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainEntry {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Cats catsInfo = ctx.getBean("catsInfo",Cats.class);
		catsInfo.getMyCatsInfo();
		
		MyCats cat2 = (MyCats)ctx.getBean("cat2");
		catsInfo.setMyCatsInfo(cat2);
		catsInfo.getMyCatsInfo();
		
		ctx.close();
	}
}
