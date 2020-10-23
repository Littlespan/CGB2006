package com.cy.pj.common.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PageObject<T> implements Serializable{

    private static final long serialVersionUID = 5267489594873568378L;

	/*找到的*/
	private Long rowCount = 0l;
	/*算到的*/
	private Integer pageCount = 0;
	/*传来的*/
	private Integer pageCurrent = 0;
	/*设置的*/
	private Integer pageSize = 1;
	/*传来的*/
	private List<T> records;
	
	
	public PageObject(Long rowCount, Integer pageCurrent,Integer pageSize,List<T> records) {
		super();
		this.pageSize=pageSize;
		this.rowCount = rowCount;
		this.pageCount = ((int)(rowCount-1)/pageSize) + 1;
		this.pageCurrent = pageCurrent;
		this.records = records;
	}

	public PageObject() {}
	
	
}
