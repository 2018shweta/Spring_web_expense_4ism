package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.SubCategoryBean;

@Repository
public class SubCategoryDao {

	
	
	@Autowired
	JdbcTemplate stmt;
	public void subCategoryAdded(SubCategoryBean subCategoryBean,int userId) {
		stmt.update("insert into subcategory (subcategoryname,categoryid,userid)values (?,?,?)",subCategoryBean.getSubCategoryName(),subCategoryBean.getCategoryId(),userId);
		
	}
	public List<SubCategoryBean> getSubCategory(int categoryId) {
		
		return	stmt.query("select * from subcategory where categoryid=?", new BeanPropertyRowMapper<SubCategoryBean>(SubCategoryBean.class),new Object [] {categoryId});
		 
	}

	
	
	
	
	
	
	
}
