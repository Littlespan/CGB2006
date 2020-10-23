package com.cy.pj.common.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class JsonResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2080943344863436345L;
	private Integer state = 1;
	private Object data;
	private String message = "ok";
	public JsonResult(Object data) {
		this.data = data;
	}
	public JsonResult() {}
	public JsonResult(String message) {
		this.message = message;
	}
	public JsonResult(Throwable e) {
		this.state = 0 ; 
		this.message=e.getMessage();
	}
	 
	
	
	
}
