package com.wangxuegang.exception;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;


/**
 * 
 * @类描述：全局异常处理
 * @项目名称：ssm
 * @包名： com.wangxuegang.exception
 * @类名称：GlobalException
 * @创建人：wangxuegang
 * @创建时间：2018年12月27日上午11:43:37
 * @mail 15510235102@163.com
 * @version v1.0
 */
public class GlobalException implements HandlerExceptionResolver{
	
	private static Logger log = Logger.getLogger(GlobalException.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest req,
			HttpServletResponse res, Object obj, Exception ex) {
		
		log.error("【全局异常】："+ex.getMessage());
		
		PrintWriter writer;
		
		try {
			writer = res.getWriter();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("code", 0);
			map.put("message", ex.getMessage());
			writer.write(JSON.toJSONString(map));
			writer.flush();
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
}
