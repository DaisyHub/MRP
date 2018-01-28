package com.edu118.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

/**
 * 专门用来打开指定页面
 */
@Controller

public class OpenPageAction {
	
	@RequestMapping("openPage")
	public String openPage(String page) {
		return "forward:/WEB-INF/pages/" + page;
	}
	
	@RequestMapping("openPageAddUser")
	public String openPageAddUser() {
		return "forward:/WEB-INF/pages/user/addUser.jsp";
	}
	
	@RequestMapping("openPageUserInfo")
	public String openPageUserInfo() {
		return "forward:/WEB-INF/pages/user/userInfo.jsp";	
	}
	
	@RequestMapping("logout")
	public String logout(SessionStatus sessionStatus,HttpServletRequest request) {
		//清除SpringMVC的Session中数据
		sessionStatus.setComplete();
		
		//清除HttpSession中的数据
		request.getSession().invalidate();
		return "forward:/login.jsp";				
	}
}
