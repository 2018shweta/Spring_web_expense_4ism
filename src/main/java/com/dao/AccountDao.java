package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AccountBean;

@Repository
public class AccountDao {

	
	@Autowired
	JdbcTemplate stmt;

	public void accountAdded( AccountBean accountBean,int userid) {
		
		stmt.update("insert into account (userid,accounttype,ammount,cardid,upiid,isactive)values(?,?,?,?,?,?)",userid,accountBean.getAccountType(),accountBean.getAmmount(),accountBean.getCardId(),accountBean.getUpiId(),accountBean.getIsActive());
		System.out.println(userid);
		System.out.println(accountBean.getAccountType());
		System.out.println(accountBean.getAmmount());
	}

	public List<AccountBean> getAccountDetails(int userId) {
	
		
		
		return stmt.query("select * from  account where userid=?",new BeanPropertyRowMapper<AccountBean>(AccountBean.class),new Object[] {userId});
	}

	
	public List<AccountBean> sum(int userId)
	{
		return stmt.query("select sum(ammount) as ammount from account where userid=?",new BeanPropertyRowMapper<AccountBean>(AccountBean.class),new Object[] {userId});
	}

	public List<AccountBean> getAmmountByAccountId(int accountId) {
		return stmt.query("select * from account where accountid=?",new BeanPropertyRowMapper<AccountBean>(AccountBean.class),new Object[] {accountId} );
		
	}
	public void updateMoney(int accountId, int editammount) {
	stmt.update("update account set ammount=? where accountid=?",editammount,accountId);
		
	}

	public void updatedfAm(int acId, int fAm) {
		stmt.update("update account set ammount=? where accountid=?",fAm,acId);
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
