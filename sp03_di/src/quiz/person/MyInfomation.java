package quiz.person;

import java.util.ArrayList;

public class MyInfomation {

	private Person person;  // hash-a 

	// setter method
	public void setPerson(Person person) {  // DI
		this.person = person;
	}
	
	public boolean processMessage(StudentPersonImpl student) {
		return this.person.personShow(student.getName(), student.getAge(), student.getGender());
	}
	
	public boolean processMessage(EmployeePersonImpl emp) {
		return this.person.personShow(emp);
	}
	
	public boolean processMessage(String name, int age, String gender) {
		return this.person.personShow(name, age, gender);
	}
}
