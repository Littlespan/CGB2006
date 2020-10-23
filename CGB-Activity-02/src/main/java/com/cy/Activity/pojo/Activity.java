package com.cy.Activity.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Activity {
	private Long id;
	private String title;
	private String category;
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm",timezone = "GMT+8")
	private Date startTime;
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm",timezone = "GMT+8")
	private Date endTime;
	private String remark;
	private Short state=1;
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm",timezone = "GMT+8")
	private Date createdTime;
	private String createdUser;
}
