package ex03.di;

import lombok.Data;

@Data    // @Setter 있음
public class MyInfomation {
	
	private Person  person;   // has-a
	
	// setter method DI
	
	public boolean proessMessage(StuentPersonImpl student) {
		return this.person.personShow(student.getName(), student.getAge(), student.getGender());
	}

	public boolean proessMessage(EmployeePersonImpl emp) {
		return  this.person.personShow(emp);
	}
	
	public boolean proessMessage(String name, int age, String gender) {
		return this.person.personShow(name, age, gender);
	}
}
