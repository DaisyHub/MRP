package com.edu118.user;

public class EditUser {
	public static void main(String[] args) {
		editUser(
				2,1,
				"xyd","xyd");
		
		//当前用户==》		1
		//要修改的用户==》	1
	}
	
	public static void editUser(
			int currLevel,int editLevtl,
			String currName,String editName) {
		
		//用户名相同，权限相同，认定为同一个用户，只能修改密码和描述信息
		if (currName.equals(editName) && currLevel == editLevtl) {
			//自己修改自己的密码和描述信息
			System.out.println("修改自己的数据");
			
		//权限只能是0或者1，才可以修改其他用户的数据
		//管理员的权限是0，主管的权限是1，按数字的大小进行比较，如果当前的用户权限小于要修改的用户权限，则可以修改
		}else if((currLevel + "").matches("[01]") && currLevel < editLevtl ) {
			//修改其他用户的数据
			System.out.println("修改其他用户的数据");
			
		}else {
			System.out.println("权限不足！");
		}
		
		
	}
}
