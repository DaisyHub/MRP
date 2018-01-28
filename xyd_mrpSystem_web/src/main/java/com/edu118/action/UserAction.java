package com.edu118.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.edu118.md5.MD5Utils;
import com.edu118.pagingbean.MyPagin;
import com.edu118.po.User;
import com.edu118.user.UserService;
import com.edu118.validated_groups.V_GroupThree;
import com.edu118.validated_groups.V_GroupTwo;
import com.edu118.validation.ValueRuleValidator;
import com.edu118.vo.DataResult;

/**
 * 用于处理所有的用户数据操作
 * 信盈达科技 2017年12月27日 下午4:30:04 
 * @author MuYu
 */
@Controller
//如果Action返回的数据是JSON类型的，需要加一个注解
@ResponseBody	//把返回的JSON数据保存到Request域中	需要添加Jackson Json依赖，有3个包
public class UserAction {
	@Resource 
	private UserService userService;
	
	@RequestMapping("editUserData")
	public DataResult<User> editUserData(
			@Validated({V_GroupThree.class}) User user,BindingResult bResult,
			String conPass,
			boolean isEditUser,@SessionAttribute("currUser") User currUser) {
		
		DataResult<User> dataResult = new DataResult<>();
		
		if (bResult.hasErrors()) {
			dataResult.setMessage(bResult.getAllErrors().get(0).getDefaultMessage());
			
		}else if(ValueRuleValidator.isString(user.getPassword()) && !user.getPassword().matches("\\w{6,12}") ) {
			dataResult.setMessage("您输入的密码不正确！");
			
		}else if(ValueRuleValidator.isString(user.getPassword()) && !user.getPassword().equals(conPass)) {
			dataResult.setMessage("您输入的再次密码不一致！");
			
		}else {
			//如果是true，表示数据需要修改
			if (isEditUser) {
				//先得通过要修改的用户名来查询原来的权限
				String editLevel = userService.selectUserByUsername(user.getUsername()).getLevel();
				
				//判断是否是自己修改自己的数据，通过用户名和权限相同来判断
				if (currUser.getUsername().equals(user.getUsername()) &&
						currUser.getLevel().equals(editLevel)) {
					//修改自己的用户信息
					user.setLevel(null);
					if(!ValueRuleValidator.isString(user.getPassword())) {
						user.setPassword(null);
					}else {
						user.setPassword(MD5Utils.getPassword(user.getPassword()));
					}
					if(userService.updateUserData(user) > 0) {
						dataResult.setMessage("用户数据修改完成！");
						dataResult.setState(true);
					}
					
				
				}else if (currUser.getLevel().matches("[01]") &&
						//当前登陆的用户权限 < 要修改之后的用户权限
						Integer.parseInt(currUser.getLevel()) < Integer.parseInt(user.getLevel())
						//当前登陆的用户权限 < 要修改之前的用户权限
						&& Integer.parseInt(currUser.getLevel()) < Integer.parseInt(editLevel)) {
					
					//可以修改其他用户的权限
					if(!ValueRuleValidator.isString(user.getPassword())) {
						user.setPassword(null);
					}else {
						user.setPassword(MD5Utils.getPassword(user.getPassword()));
					}
					if(userService.updateUserData(user) > 0) {
						dataResult.setMessage("用户数据修改完成！");
						dataResult.setState(true);
					}
					
				}else {
					
					dataResult.setMessage("您没有修改当前用户信息的仅限！");
				}
				
			}else {
				dataResult.setMessage("当前用户【" + user.getUsername() + "】的数据不需要进行修改！");
			}
		}
		
		return dataResult;
	}
	
	/**
	 * 用户数据的分页查询
	 */
	@RequestMapping("pagingQueryUserData")
	public MyPagin pagingQueryUserData(MyPagin myPagin,String column,String keyword) {
		
		//查询总的记录数
		myPagin.setTotalRecords(userService.pagingUserDataCount(column, keyword));
		
		//查询到前5条数据
		
		myPagin.setData(userService.pagingUserData(myPagin, column, keyword));
		
		return myPagin;
	}
	
	
	//@RequestMapping(value = "addUser",produces = "text/html; charset=UTF-8")
	@RequestMapping(value = "addUser",produces = "application/json")	
	/*public String addUser(User user,String conPass,
			@SessionAttribute("currUser") User currUser) {*/
	
	public DataResult<User> addUser(
			@Validated({V_GroupTwo.class}) User user,BindingResult bResult,
			String conPass,
			@SessionAttribute("currUser") User currUser) {
		
		System.out.println(user);
		
		DataResult<User> dataResult = new DataResult<>();
		
		String errors = "";
		
		//验证User数据是否符合要求
		if (bResult.hasErrors()) {
			for(ObjectError oeError : bResult.getAllErrors()) {
				errors += (oeError.getDefaultMessage() + "<br>");
			}
			dataResult.setMessage(errors);
			return dataResult;
		}
		
		try {
			int currUserLevel = Integer.parseInt(currUser.getLevel());
			int userLevel = Integer.parseInt(user.getLevel());
			
			//进行权限的验证
			if (currUser.getLevel() == null || 
					!currUser.getLevel().matches("[01]") ||
					currUserLevel >= userLevel) { 
				//没有权限添加用户数据
				dataResult.setMessage("您没有添加用户的权限！");
				
				//返回的是一个JSON字符串  dataResult==》JSON
				//return JSON.toJSONString(dataResult); 
				return dataResult;
			}
		} catch (NumberFormatException e) {
			dataResult.setMessage("您输入的权限不符合要求！");
			return dataResult;
		}
		//添加用户数据
		//判断当前用户是否存在
		if(userService.selectUserByUsername(user.getUsername()) != null) {
			dataResult.setMessage("当前用户要添加的用户已经存在！");
			//return JSON.toJSONString(dataResult);
			return dataResult;
		}
		
		//判断两次输入的密码是否一致
		if (!user.getPassword().equals(conPass)) {
			//密码不一致
			dataResult.setMessage("您输入的两次密码不一致！");
			return dataResult;
		}
		
		//实现用户的添加 把密码进行MD5处理
		user.setPassword(MD5Utils.getPassword(user.getPassword()));
		if(userService.insertUser(user)) {
			dataResult.setMessage("用户已添加完成！");
			dataResult.setState(true);
			
		}else {
			dataResult.setMessage("用户添加失败！");
		}
		
		
		return dataResult;
	}
}
