package com.cy.pj.common.utils;
import org.apache.shiro.SecurityUtils;
import com.cy.pj.common.vo.SysUserDeptVo;;
public class ShiroUtils {
	
	
	public static String getUsername() {
		return getUser().getUsername();
	}
	
	
	public static SysUserDeptVo getUser() {
		return  (SysUserDeptVo)
				SecurityUtils.getSubject().getPrincipal();
	}
}
