package com.edu118.po;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.edu118.validated_groups.V_GroupOne;
import com.edu118.validated_groups.V_GroupThree;
import com.edu118.validated_groups.V_GroupTwo;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	//第1组验证规则：用于进行登陆验证
	@Pattern(regexp="\\w{6,12}",message="用户名的长度只能是6到12位。",
			groups= {V_GroupOne.class,V_GroupTwo.class,V_GroupThree.class})
	@NotNull(message="请输入用户名！",groups= {V_GroupOne.class,V_GroupTwo.class,V_GroupThree.class})
    private String username;

	@Pattern(regexp="\\w{6,12}",message="用户密码的长度只能是6到12位。"
			,groups= {V_GroupOne.class,V_GroupTwo.class})
	
	@NotNull(message="请输入用户密码！",groups= {V_GroupOne.class,V_GroupTwo.class})
    private String password;

	//第2组验证规则：用于进行添加用户
	@Pattern(regexp="[1234]",message="请选择正确的用户权限！"
			,groups= {V_GroupTwo.class,V_GroupThree.class})
	@NotNull(message="请选择正确的用户权限！",groups= {V_GroupTwo.class,V_GroupThree.class})
    private String level;

    private String remarks;

    public String getUsername() {
        return username;
    }

    @Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", level=" + level + ", remarks="
				+ remarks + "]";
	}

	public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}