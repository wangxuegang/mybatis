package com.wangxuegang.dao;

import com.wangxuegang.enitiy.UserEo;


/**
 * 
 * @类描述：UserDao
 * @项目名称：ssm
 * @包名： com.wangxuegang.dao
 * @类名称：UserDao
 * @创建人：wangxuegang
 * @创建时间：2018年12月24日上午11:06:29
 * @mail 15510235102@163.com
 * @version v1.0
 */
public interface UserDao {
	
	/**
	 * 
	 * @描述: 保存用户
	 * @方法名: insertUser
	 * @param userEo
	 * @返回类型 void
	 * @创建人 wangxuegang
	 * @创建时间 2018年12月27日下午1:52:34
	 * @since
	 * @throws
	 */
	void insertUser(UserEo userEo);
	
}
