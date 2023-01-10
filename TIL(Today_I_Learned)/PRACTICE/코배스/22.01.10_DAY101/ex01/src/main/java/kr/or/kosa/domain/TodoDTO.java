package kr.or.kosa.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TodoDTO {

	private String title;
	
	@DateTimeFormat(pattern = "yyyy/NN/dd")
	private Date dueDate;
}
