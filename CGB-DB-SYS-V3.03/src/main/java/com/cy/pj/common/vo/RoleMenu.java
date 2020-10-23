package com.cy.pj.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/9/12 16:25
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Data
public class RoleMenu implements Serializable {
    private static final long serialVersionUID = 7759530242781828949L;
    private Integer id;
    private String name;
    private String note;
    private Integer[] menuIds;
    private String modifiedUser;
    private Date modifiedTime;
}
