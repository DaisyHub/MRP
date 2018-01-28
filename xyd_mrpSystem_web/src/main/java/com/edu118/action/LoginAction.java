package com.edu118.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.edu118.login.LoginService;
import com.edu118.md5.MD5Utils;
import com.edu118.po.User;
import com.edu118.validated_groups.V_GroupOne;
import com.edu118.vo.DataResult;

/**
 * 负责登陆的Action
 * @author MuYu
 */
@Controller
//使用SpringMVC的注解功能，把指定的数据保存到Session域中
@SessionAttributes("currUser")
public class LoginAction {
	@Resource
	private LoginService loginService;
	
	@RequestMapping("login")
	public ModelAndView login(@Validated({V_GroupOne.class}) User user
			,BindingResult bResult,ModelMap modelMap) {
		
		ModelAndView maView = new ModelAndView("forward:/login.jsp");
		
		//创建一个返回结果的对象
		DataResult<User> dataResult = new DataResult<>();
		
		
		//后台的搭建中，要做到不会使服务器崩掉。
		//为了防止服务器崩溃，我们要做提高安全性能
		
		//判断用户提供的数据，是否符合要求
		if (bResult.hasErrors()) {
			//验证有错误信息
			
			dataResult.setMessage(bResult.getAllErrors().get(0).getDefaultMessage());
			
			//如何返回数据？返回什么样的数据？以什么类型返回？
			//可以返回对象，JSON，ModelAndView.....
			
			//后台的使用，除了收集、保存数据之后，还要提供数据，而数据，使用的最多的
			//返回数据的方式，就是JSON格式，字符串
			
			//JSON对象：{username:"muyu",password:"123"[,...]}
			//JSON数组：[{},{}[,...]]
			
			//后台的开发中，每实现一个功能，就需要提供一个接口。
			//此接口，就是从后台获取的地址。
			
			//maView.setViewName("forward:/login.jsp");
			
		}else {
			//验证用户名和密码是否正确
			//首先获取到相数据相匹配的数据
			//User result = loginService.validateUser(user);
			
			//获取到的是不带密码的用户数据	把密码进行MD5处理
			user.setPassword(MD5Utils.getPassword(user.getPassword()));
			
			User result = loginService.validateUser2(user);
			
			//拿到数据之后，对结果进行判断，判断是否为空，如果空为，表示登陆失败。
			if (result != null) {
				//完成登陆操作，跳转到主页面
				
				maView.setViewName("index");
				dataResult.setState(true);
				dataResult.setMessage("登陆成功！");
				dataResult.setData(result);
				
				modelMap.addAttribute("currUser",result);
			}else {
				//登陆失败，给出相应的提示。
				dataResult.setMessage("用户名或者密码错误！");
				//maView.setViewName("forward:/login.jsp");
				        
			}        
		}
		//maView.addObject("dataResult", dataResult);
		
		//没有指定的，会保存到Request域中   ，SpringMVC参数传递的机制。
		modelMap.addAttribute("dataResult", dataResult);		
		return maView;
	}
	
	//从Session域中获取到指定的数据
	/*public void getSessionData(@SessionAttribute("currUser") User user) {
		
	}*/
	
	public void getSessionData(HttpServletRequest request) {
		request.getSession().setAttribute("", "");
		request.getSession().getAttribute("");
	}
	
	public void getSessionData1(HttpSession session) {
		session.setAttribute("", "");
		session.getAttribute("");
	}
	
}
