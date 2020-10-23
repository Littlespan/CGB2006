package com.cy.pj.common.vo;

import com.cy.pj.sys.pojo.SysDept;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/9/14 14:01
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Data
public class SysUserDeptVo implements Serializable {

    private static final long serialVersionUID = -6498720739419417151L;
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private long mobile;
    private Integer valid;
    private Integer deptId;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;
    private SysDept sysDept;
    private Integer[] roleIds;
}
