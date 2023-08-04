package ex05.di;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO { //model
	
	private String name;
	private int age;
	private String message;
	
	//constructor
	public MemberDTO() {
		System.out.println("MemberDTO default constructor");
	}

	public MemberDTO(String name, int age, String message) {
		super();
		System.out.println("MemberDTO 필드 가지는 생성자 함수");
		this.name = name;
		this.age = age;
		this.message = message;
	}
	
}
