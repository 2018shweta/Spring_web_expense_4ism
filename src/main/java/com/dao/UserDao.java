package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.LoginBean;
import com.bean.UserBean;

@Repository
public class UserDao {
   
	
	@Autowired
	JdbcTemplate stmt;
	public void addUsers(UserBean userBean) {
		
		stmt.update("insert into users (firstname,lastname,email,password,contactnumber,gender,usertype,isactive) values (?,?,?,?,?,?,?,?)",userBean.getFirstName(),userBean.getLastName(),userBean.getEmail(),userBean.getPassword(),userBean.getContactNumber(),userBean.getGender(),userBean.getUserType(),userBean.getIsActive());
		
		System.out.println(userBean.getFirstName());
		
	}
	public  UserBean loginUser(LoginBean loginBean) {
		
		
		
		
		List<UserBean> users=null;
		try {
		   users= stmt.query("select * from users where email=? and password=?",new BeanPropertyRowMapper<UserBean>(UserBean.class),new Object[] {loginBean.getEmail(),loginBean.getPassword()});	
		}catch(Exception e)
		{
			System.out.println("user not availabel");
		}
	
		if(users.size()==0)
		{
			return null;
		}
		else {
			return users.get(0);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
}
