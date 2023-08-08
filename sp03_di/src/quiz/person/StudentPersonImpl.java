package quiz.person;

import java.util.ArrayList;

public class StudentPersonImpl implements Person {

	private String name, gender;
	private int age;
	private ArrayList<Integer> score;

	@Override
	public boolean personShow(String name, int age, String gender) {
		this.name = name;
		
		System.out.println(name + " / " + age + " / " + gender);
		return true;
	}
	
	@Override
	public boolean personShow(Person person) {
		//person = new StudentPersonImpl();
		System.out.println(name+ " / "+ age+ " / "+ gender);
		return true;
	}	
	
	public boolean personShow(StudentPersonImpl student) {
		System.out.println(student.getName()+ " / "+ student.getAge()+ " / "+ student.getGender());
		return true;
	}
	
	public boolean personShow( ArrayList<Integer> score ) {
		for (int i = 0; i < score.size() ; i++) {
			System.out.println(score);
		}
		
		return true;
	}
	
	// setter / getter method
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<Integer> getScore() {
		return score;
	}

	public void setScore(ArrayList<Integer> score) {
		this.score = score;
	}


}
