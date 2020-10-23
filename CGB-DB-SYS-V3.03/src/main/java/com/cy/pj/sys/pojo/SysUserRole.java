package com.cy.pj.sys.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/9/14 19:20
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Data
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = 146029449032348223L;
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private Integer deptId;
    private String email;
    private Long mobile;
    private Date createdTime;
    private String createdUser;
    private Integer[] roleIds;
}
