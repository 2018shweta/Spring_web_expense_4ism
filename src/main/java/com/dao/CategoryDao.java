package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CategoryBean;

@Repository
public class CategoryDao {

	
	@Autowired
	JdbcTemplate stmt;

	public void addCategory(CategoryBean categoryBean,int userId) {
		stmt.update("insert into category (categoryname,userid) values(?,?)",categoryBean.getCategoryName(),userId);
		
	}

	public List<CategoryBean> allCategory(int userId) {
		
		
		
		
		
		return stmt.query("select * from category where userid=7 or userid=?",new BeanPropertyRowMapper<CategoryBean>(CategoryBean.class),new Object[] {userId});
	}

	
	

	
	
	
}
