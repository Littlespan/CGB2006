package com.cy.pj.activity.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class Activity {
	private Long id;
	private String title;
	private String category;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date startTime;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date endTime;
	private String remark;
	private Short state;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date createdTime;
	private String cteatedUser;
}
