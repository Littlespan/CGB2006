package com.cy.pj.sys.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/9/11 19:44
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Data
public class SysMenu implements Serializable {
    private static final long serialVersionUID = -8805983256624854549L;
    private Integer id;
    /**菜单名称*/
    private String name;
    /**菜单url: log/doFindPageObjects*/
    private String url;
    /**菜单类型(两种:按钮,普通菜单)*/
    private Integer type=1;
    /**排序(序号)*/
    private Integer sort;
    /**备注*/
    private String note;
    /**上级菜单id*/
    private Integer parentId;
    /**菜单对应的权限标识(sys:log:delete)*/
    private String permission;
    /**创建用户*/
    private String createdUser;
    /**修改用户*/
    private String modifiedUser;
    private Date createdTime;
    private Date modifiedTime;

}
