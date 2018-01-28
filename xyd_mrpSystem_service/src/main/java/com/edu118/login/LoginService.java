package com.edu118.login;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edu118.mapper.UserMapper;
import com.edu118.mapper.custom_mapper.CustomUserMapper;
import com.edu118.po.User;
import com.edu118.po.UserExample;

/**
 * 用于用户登陆的数据验证
 * @author MuYu
 */
@Service
public class LoginService {
	@Resource
	private UserMapper userMapper;		//Dao
	
	@Resource
	private CustomUserMapper customUserMapper;
	
	
	/**
	 * 根据用户名或者加上密码查询用户数据<br>
	 * 查询到的数据，不带密码
	 * @param user	用户传递过来的数据
	 * @return	从数据库中查询到的数据
	 */
	public User validateUser2(User user) {
		return customUserMapper.findUserByUOrP(user);
	}
	
	
	
	
	/**
	 * 通过用户名和用户密码查询用户数据
	 * @param user 传入的参数，是由用户提供的
	 * @return User 是从数据库查询到的，如果查询不到，返回的是null
	 */
	public User validateUser(User user ) {
		
		UserExample example = new UserExample();
		//通过用户名和用户密码查询用户数据
		example.createCriteria().andUsernameEqualTo(user.getUsername())
			.andPasswordEqualTo(user.getPassword());	//链式编程
		
		//
		
		List<User> users = userMapper.selectByExample(example );
		
		return users.size() > 0 ? users.get(0) : null;
	}
}
