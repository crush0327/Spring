package quiz.person;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {

	public static void main(String[] args) {
		ApplicationContext  ctx = 
				new ClassPathXmlApplicationContext("quiz/person/ctx.xml");
		
		StudentPersonImpl student = ctx.getBean("student", StudentPersonImpl.class);
		EmployeePersonImpl emp = ctx.getBean("employee", EmployeePersonImpl.class);
		
		MyInfomation info = ctx.getBean("info", MyInfomation.class);
		//info.setPerson(new StudentPersonImpl());
		info.processMessage(student);
		//info.processMessage(new StudentPersonImpl());
		info.processMessage("doyeon", 33, "남자");

		ArrayList<String> hobbys = new ArrayList();
		hobbys.add("aa");
		hobbys.add("bb");
		hobbys.add("cc");
		
		MyInfomation info2 = ctx.getBean("info2", MyInfomation.class);
		emp.personShow(hobbys);
		info2.processMessage(emp);
		
		//ctx.close();
	}
}
