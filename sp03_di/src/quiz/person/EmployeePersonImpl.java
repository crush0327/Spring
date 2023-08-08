package quiz.person;

import java.util.ArrayList;

public class EmployeePersonImpl implements Person {

	private String name, gender;
	private int age;
	private ArrayList<String> hobbys;
	
	public EmployeePersonImpl(){ }
	
	public EmployeePersonImpl(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "EmployeePersonImpl [name=" + name + ", gender=" + gender + ", age=" + age + ", hobbys=" + hobbys + "]";
	}

	@Override
	public boolean personShow(String name, int age, String gender) {
		System.out.println(name + " / " + age + " / " + gender);
		return true;
	}

	@Override
	public boolean personShow(Person person) {
		//person = new EmployeePersonImpl();
		System.out.println(person);
		return true;
	}

	public boolean personShow( ArrayList<String> hobbys ) {
		for (int i = 0; i < hobbys.size() ; i++) {
			System.out.println(hobbys);
		}
		return true;
	}

}
