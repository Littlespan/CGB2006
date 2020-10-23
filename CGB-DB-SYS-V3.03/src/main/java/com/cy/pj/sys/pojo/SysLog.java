package com.cy.pj.sys.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class SysLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1512255100327727252L;
	private Long id;
	private String username;
	private String operation;
	private String method;
	private String params;
	private Long time;
	private String ip;
	private Date createdTime;

    public SysLog(String username, String operation, String method, String params, Long time, String ip, Date createdTime) {
        this.username = username;
        this.operation = operation;
        this.method = method;
        this.params = params;
        this.time = time;
        this.ip = ip;
        this.createdTime = createdTime;
    }
    public SysLog(){};
}
