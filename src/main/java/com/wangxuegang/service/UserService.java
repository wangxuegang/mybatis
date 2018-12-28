package com.wangxuegang.service;

import java.util.List;

import com.wangxuegang.model.UserVo;

/**
 * 
 * @类描述：UserService
 * @项目名称：ssm
 * @包名： com.wangxuegang.service
 * @类名称：UserService
 * @创建人：wangxuegang
 * @创建时间：2018年12月24日下午3:04:23
 * @mail 15510235102@163.com
 * @version v1.0
 */
public interface UserService {
	
	/**
	 * 
	 * @描述: 添加用户
	 * @方法名: saveUser
	 * @param userVo
	 * @throws Exception
	 * @返回类型 void
	 * @创建人 wangxuegang
	 * @创建时间 2018年12月27日下午1:53:25
	 * @since
	 * @throws Exception
	 */
	void saveUser(UserVo userVo) throws Exception;
	
	/**
	 * 
	 * @描述: 用户列表
	 * @方法名: getUserList
	 * @return
	 * @返回类型 List<UserVo>
	 * @创建人 wangxuegang
	 * @创建时间 2018年12月27日下午2:29:47
	 * @since
	 * @throws
	 */
	List<UserVo> getUserList();
	
	/**
	 * 
	 * @描述: 删除用户
	 * @方法名: deleteUser
	 * 
	 * @返回类型 void
	 * @创建人 wangxuegang
	 * @创建时间 2018年12月27日下午4:27:14
	 * @since
	 * @throws
	 * @param userVo 
	 */
	void deleteUser(UserVo userVo);
	
	/**
	 * 
	 * @描述: 编辑用户
	 * @方法名: updateUser
	 * @param userVo
	 * @返回类型 void
	 * @创建人 wangxuegang
	 * @创建时间 2018年12月27日下午4:48:19
	 * @since
	 * @throws
	 
	 */
	void updateUser(UserVo userVo);
}
