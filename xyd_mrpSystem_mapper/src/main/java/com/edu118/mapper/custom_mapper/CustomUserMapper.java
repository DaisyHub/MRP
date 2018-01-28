package com.edu118.mapper.custom_mapper;

import java.util.List;

import com.edu118.po.User;
import com.edu118.po.UserExample;

public interface CustomUserMapper {
	public User findUserByUOrP(User user);
	
	List<User> selectByExampleNotPassword(UserExample example);
}
