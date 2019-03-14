package com.wangxuegang.user;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangxuegang.dao.UserDao;
import com.wangxuegang.model.UserVo;
import com.wangxuegang.service.UserService;

/**
 * 
 * @类描述：单元测试
 * @项目名称：blog
 * @包名： com.wangxuegang.user
 * @类名称：UserTest
 * @创建人：wangxuegang
 * @创建时间：2019年3月14日上午10:29:54
 * @mail 15510235102@163.com
 * @version v1.0
 */
public class UserTest {
	
	private static ApplicationContext ac = null;
	
	static {
		ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}
	
	@Test
	public void userServiceAdd() throws Exception{
		
		
		UserService userService = (UserService) ac.getBean("userService");
		
		System.out.println(userService);
		UserVo userVo = new UserVo();
		userVo.setLoginName("wangxuegang");
		userVo.setUserName("wangxuegang");
		userVo.setPassword("123123");
		userVo.setPhone("88888888");
		userVo.setEmail("8888@163.com");
		userService.saveUser(userVo);
	}
	
	@Test
	public void userDaoAdd(){
		
		UserDao userDao = (UserDao) ac.getBean("userDao");
		System.out.println(userDao);
		
	}
	
	@Test
	public void sqlSessionFactory(){
		
		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
		System.out.println(sqlSessionFactory);
		
	}
	
	@Test
	public void dataSource(){
		DataSource ds = (DataSource) ac.getBean("dataSource");
		System.out.println(ds);
	}
}
