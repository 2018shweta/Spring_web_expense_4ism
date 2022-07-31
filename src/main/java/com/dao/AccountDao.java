package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AccountBean;

@Repository
public class AccountDao {

	
	@Autowired
	JdbcTemplate stmt;

	public void accountAdded( AccountBean accountBean,int userid) {
		stmt.update("insert into account (userid,accounttype,ammount)values(?,?,?)",userid,accountBean.getAccountType(),accountBean.getAmmount());
		System.out.println(userid);
		System.out.println(accountBean.getAccountType());
		System.out.println(accountBean.getAmmount());
	}
	
	
	
	
	
	
	
	
	
	
	
}
