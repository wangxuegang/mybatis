package com.wangxuegang.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangxuegang.model.UserVo;
import com.wangxuegang.service.UserService;

/**
 * 
 * @类描述：UserController
 * @项目名称：ssm
 * @包名： com.wangxuegang.controller
 * @类名称：UserController
 * @创建人：wangxuegang
 * @创建时间：2018年12月24日下午4:47:38
 * @mail 15510235102@163.com
 * @version v1.0
 
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * @描述: 添加用户
	 * @方法名: addUser
	 * @param userVo
	 * @return
	 * @返回类型 Map<String,Object>
	 * @创建人 wangxuegang
	 * @创建时间 2018年12月24日下午5:02:14
	 * @since
	 * @throws Exception 
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public Map<String,Object> addUser(@RequestBody UserVo userVo) throws Exception{
		Map<String,Object> map = this.getMap();
		userService.saveUser(userVo);
		map.put("code", 1);
		map.put(this.SUCCESS, "添加成功");
		return map;
	}
	
	/**
	 * 
	 * @描述: 用户列表
	 * @方法名: getUserList
	 * @return
	 * @返回类型 Map<String,Object>
	 * @创建人 wangxuegang
	 * @创建时间 2018年12月27日下午2:27:25
	 * @since
	 * @throws
	 */
	@RequestMapping("/userList")
	@ResponseBody
	public Map<String,Object> getUserList(){
		Map<String,Object> map = this.getMap();
		List<UserVo> list = userService.getUserList();
		map.put("code", 1);
		map.put(this.SUCCESS, list);
		return map;
	}
	
	/**
	 * 
	 * @描述: 删除用户
	 * @方法名: getUserList
	 * @param userVo
	 * @return
	 * @返回类型 Map<String,Object>
	 * @创建人 wangxuegang
	 * @创建时间 2018年12月27日下午4:25:59
	 * @since
	 * @throws
	 */
	@RequestMapping("/delUser")
	@ResponseBody
	public Map<String,Object> delUser(@RequestBody UserVo userVo){
		Map<String,Object> map = this.getMap();
		userService.deleteUser(userVo);
		map.put("code", 1);
		map.put(this.SUCCESS, "删除成功");
		return map;
	}
	
	/**
	 * 
	 * @描述: 编辑用户
	 * @方法名: editUser
	 * @return
	 * @返回类型 Map<String,Object>
	 * @创建人 wangxuegang
	 * @创建时间 2018年12月27日下午4:46:46
	 * @since
	 * @throws
	 */
	@RequestMapping("/editUser")
	@ResponseBody
	public Map<String,Object> editUser(@RequestBody UserVo userVo){
		Map<String,Object> map = this.getMap();
		userService.updateUser(userVo);
		map.put("code", 1);
		map.put(this.SUCCESS, "编辑成功");
		return map;
	}
}
