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

	public void addExpense(ExpenseBean expenseBean, int userId) {

		stmt.update(
				"insert into expense (userid,categoryname,typeofpayment,expenseammount,date,time,description,categoryid)values (?,?,?,?,?,?,?,?)",
				userId, expenseBean.getCategoryName(), expenseBean.getTypeOfPayment(), expenseBean.getExpenseAmmount(),
				expenseBean.getDate(), expenseBean.getTime(), expenseBean.getDescription(),expenseBean.getCategoryId());

	}

	public List<ExpenseBean> allExpenseList(int userId) {

		return stmt.query("select * from expense where userid=?",
				new BeanPropertyRowMapper<ExpenseBean>(ExpenseBean.class), new Object[] { userId });

		//select e.* ,c.categoryname  from expense e , category c where c.categoryid=e.categoryid and userid=?
		
	}

	public void deleteExpense(int expenseId) {
		stmt.update("delete from expense where  expenseid=?", expenseId);

	}

	public ExpenseBean getExpenseByExpenseId(int expenseId) {
		ExpenseBean expense=stmt.queryForObject("select * from expense where expenseid=?",new BeanPropertyRowMapper<ExpenseBean>(ExpenseBean.class),new Object[] {expenseId});
		return expense;
	}

	public void updateExpense(ExpenseBean expenseBean) {
	stmt.update("update expense set date=?,time=? where expenseid=?",expenseBean.getDate(),expenseBean.getTime(),expenseBean.getExpenseId());
		
	}

	public List<ExpenseBean> sum(int userId) {
		return stmt.query("select sum(expenseammount) as expenseammount from expense where userid=?",new BeanPropertyRowMapper<ExpenseBean>(ExpenseBean.class),new Object[] {userId});
		
	}

	
}
