package com.cy.pj.sys.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/9/12 10:08
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID = 5521382623140029010L;
    private Integer id;
    private String name;
    private String note;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;
}
