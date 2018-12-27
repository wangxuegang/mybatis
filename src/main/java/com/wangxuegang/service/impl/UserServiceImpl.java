package com.wangxuegang.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangxuegang.dao.UserDao;
import com.wangxuegang.enitiy.UserEo;
import com.wangxuegang.model.UserVo;
import com.wangxuegang.service.UserService;

/**
 * 
 * @类描述：UserServiceImpl
 * @项目名称：ssm
 * @包名： com.wangxuegang.service.impl
 * @类名称：UserServiceImpl
 * @创建人：wangxuegang
 * @创建时间：2018年12月24日下午3:05:49
 * @mail 15510235102@163.com
 * @version v1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void saveUser(UserVo userVo) throws Exception{
		UserEo userEo = new UserEo();
		BeanUtils.copyProperties(userVo, userEo);
		userDao.insertUser(userEo);
	}

}
