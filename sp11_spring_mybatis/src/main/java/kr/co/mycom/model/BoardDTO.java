package kr.co.mycom.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
	private int num;
	private String name, email, pwd, subject, content;
	private Date regdate;
	private int hit, parent, sort, tab;
}
