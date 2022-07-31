package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ExpenseBean;

@Repository
public class ExpenseDao {

	
	@Autowired
	JdbcTemplate stmt;

	public void addExpense(ExpenseBean expenseBean,int userId) {
		
		stmt.update("insert into expense (userid,category,typeofpayment,expenseammount,date,time,description)values (?,?,?,?,?,?,?)",userId,expenseBean.getCategory(),expenseBean.getTypeOfPayment(),expenseBean.getExpenseAmmount(),expenseBean.getDate(),expenseBean.getTime(),expenseBean.getDescription());
		
		
	}

	public List<ExpenseBean> allExpenseList(int userId) {
		
		
		return	stmt.query("select * from expense where userid=?", new BeanPropertyRowMapper<ExpenseBean>(ExpenseBean.class),new Object[] {userId});
		
		
		
		
	}

	public void deleteExpense(int expenseId, int userId) {
		stmt.update("delete from expense where userid=? and expenseid=?",userId,expenseId);
		
	}
	
	
	
}
