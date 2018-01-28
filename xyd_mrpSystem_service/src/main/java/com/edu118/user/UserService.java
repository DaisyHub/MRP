package com.edu118.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edu118.mapper.UserMapper;
import com.edu118.mapper.custom_mapper.CustomUserMapper;
import com.edu118.pagingbean.MyPagin;
import com.edu118.po.User;
import com.edu118.po.UserExample;
import com.edu118.po.UserExample.Criteria;

/**
 * 用于处理User数据的Service
 * 信盈达科技 2017年12月28日 下午4:09:26 
 * @author MuYu
 */
@Service
public class UserService {
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private CustomUserMapper customUserMapper;
	
	/**
	 * 根据用户名来修改用户数据
	 * @param user	用户传递过来的数据
	 * @return	返回修改的数据行数
	 */
	public int updateUserData(User user) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(user.getUsername());
		return userMapper.updateByExampleSelective(user, example);
	}
	
	/**
	 * 分页的模糊查询
	 * @param myPagin	分页的实体类对象
	 * @param column	模糊查询的字段
	 * @param keyword	模糊查询的条件
	 * @return
	 */
	public List<User> pagingUserData(MyPagin myPagin,String column,String keyword){
		UserExample example = new UserExample();
		
		//分页查询的实现
		example.setMyPagin(myPagin);
		
		//查询的字段和条件
		Criteria criteria = example.createCriteria();
		if ("username".equals(column)) {
			//在MyBatis的逆向工程中，是可以使用模糊的
			criteria.andUsernameLike("%" + keyword + "%");
		}else if ("level".equals(column)) {
			criteria.andlevelEqualTo(keyword);
		}
		//不查询管理员信息
		criteria.andlevelNotEqualTo("0");
		//原有的查询，是带密码的
		//List<User> users = userMapper.selectByExample(example );		
		
		//自定义的查询，是没有密码数据的
		return customUserMapper.selectByExampleNotPassword(example );
	}
	
	/**
	 * 查询总的数据数量
	 * @param column	查询字段
	 * @param keyword	查询条件
	 * @return
	 */
	public long pagingUserDataCount(String column, String keyword) {
		UserExample example = new UserExample();
		
		//查询的字段和条件
		Criteria criteria = example.createCriteria();
		if ("username".equals(column)) {
			//在MyBatis的逆向工程中，是可以使用模糊的
			criteria.andUsernameLike("%" + keyword + "%");
		}else if ("level".equals(column)) {
			criteria.andlevelEqualTo(keyword);
		}
		//不查询管理员数据
		criteria.andlevelNotEqualTo("0");
		
		return userMapper.countByExample(example );
	}
	
	
	//定义一个根据用户名查询数据的方法
	public User selectUserByUsername(String username) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<User> users = userMapper.selectByExample(example);
		return users.size() > 0 ? users.get(0) : null;
	}
	
	//添加用户数据
	public boolean insertUser(User user) {
		return userMapper.insert(user) > 0 ? true : false;
	}

}
