package com.cy.pj.sys.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class UpdatePwd implements Serializable{

	private static final long serialVersionUID = 2204446978660359562L;
	private String pwd;
	private String newPwd;
	private String cfgPwd;
	private String salt;

}
