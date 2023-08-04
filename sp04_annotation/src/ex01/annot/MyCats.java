package ex01.annot;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyCats {
	
	private String name;
	private int age;
	private ArrayList<String> hobbys;
	private double weight;
	private String color;
	
	public MyCats(String name, int age, ArrayList<String> hobbys) {
		super();
		this.name = name;
		this.age = age;
		this.hobbys = hobbys;
	}	
	
	
}
