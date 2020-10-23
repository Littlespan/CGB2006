package com.cy.pj.sys.pojo;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;


@Data
public class SysLog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1592163223057343412L;
	private Long id;
	private String username;
	private String operation;
	private String method;
	private String params;
	private Long time;
	private String ip;
	private Date createdTime;
}
