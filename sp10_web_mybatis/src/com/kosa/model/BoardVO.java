package com.kosa.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardVO {

		private int seq, readcount;
		private String title, writer, content;
		private Date regdate;
		
		private String searchCondition;
		private String searchKeyword;
	
}
