package com.cy.pj.sys.service.impl;

import com.cy.pj.common.annotation.RequiredLog;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.pojo.PageObject;
import com.cy.pj.common.utils.ShiroUtils;
import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.pojo.SysUserRole;
import com.cy.pj.sys.pojo.UpdatePwd;
import com.cy.pj.sys.service.SysUserService;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/9/14 14:43
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    @RequiredLog("查找用户")
    @Transactional(readOnly = true)
    @RequiresPermissions("sys:user:view")
    public PageObject<SysUserDeptVo> findPageObjects(String username, Integer pageCurrent) {
        int rows = sysUserDao.getRowCount(username);
        int pageSize=10;
        int startIndex=(pageCurrent-1)*pageSize;
        return new PageObject<>((long)rows,pageCurrent,pageSize,sysUserDao.findPageObjects(username,startIndex,pageSize));
    }

    @Override
    @RequiresPermissions("sys:user:update")
    public int validById(Integer id, Integer valid) {
        if(id==null||id<1)
            throw new ServiceException("ID无效");
        if(valid!=0 &&valid!=1)
            throw new ServiceException("状态值无效");
        int rows = sysUserDao.validById(id, valid);
        return rows;
    }

    @Override
    @RequiredLog("保存用户")
    @Transactional //由此注解描述的方法为一个目标切入点方法，后续运行时会对它描述的方法进行事务控制
   @RequiresPermissions("sys:user:add")
    public int saveObject(SysUserRole sysUserRole) {
        if(sysUserRole==null)
            throw new ServiceException("输入不能为空");
        String salt = UUID.randomUUID().toString();
        sysUserRole.setSalt(salt);
        SimpleHash sh = new SimpleHash("MD5",
                sysUserRole.getPassword(),
                salt,
                1);
        String hashedPsw = sh.toHex();
        sysUserRole.setPassword(hashedPsw);
        int rows = sysUserDao.doSaveObject(sysUserRole);
        sysUserRoleDao.insertObjectsByUserId(sysUserRole);
        return rows;
    }

    @Override
    public SysUserDeptVo findPageObjectById(Integer id) {
        SysUserDeptVo sysUserDeptVo = sysUserDao.findPageObjectById(id);
        sysUserDeptVo.setRoleIds(sysUserRoleDao.findObjectByUserId(id));
        return sysUserDeptVo;
    }

    @Override
    @RequiresPermissions("sys:user:update")
    public int updateObject(SysUserRole sysUserRole) {
        int rows = sysUserDao.updateObject(sysUserRole);
        sysUserRoleDao.deleteObjectsByUserId(sysUserRole);
        sysUserRoleDao.insertObjectsByUserId(sysUserRole);
        return rows;
    }

	@Override
	public int doUpdatePassword(UpdatePwd updatePwd) {
		String Pwd = updatePwd.getPwd();
		String newPwd = updatePwd.getNewPwd();
		String cfgPwd = updatePwd.getCfgPwd();
		if(!newPwd.equals(cfgPwd))
    		throw new ServiceException("两次输入密码不相同");
		String username = ShiroUtils.getUsername();
		SysUserDeptVo User = sysUserDao.findUserByUserName(username);
		String PwdHex = new SimpleHash("MD5", Pwd, User.getSalt(), 1).toHex();
		if(!User.getPassword().equals(PwdHex))
			throw new ServiceException("原密码输入错误");
		if(Pwd.equals(newPwd))
			throw new ServiceException("密码与原密码相同");
		String salt = UUID.randomUUID().toString();
		String newPwdHex = new SimpleHash("MD5", newPwd, salt, 1).toHex();
		User.setPassword(newPwdHex);
		User.setSalt(salt);
		int rows = sysUserDao.updatePassword(User);
		return rows;
	}
}
