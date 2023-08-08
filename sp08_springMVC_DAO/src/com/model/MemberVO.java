package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor     // all member field constructor
@NoArgsConstructor    // default constructor
@Data     // setter, getter , toString method
public class MemberVO {
	
	private String id, name, pwd, email;
	private int age;
}


/*
   id varchar2(20),
    name varchar2(20),
    pwd varchar2(20),
    email varchar2(30),
    age int
*/