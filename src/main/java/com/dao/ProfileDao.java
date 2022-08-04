package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ProfileBean;

@Repository
public class ProfileDao {

	
	@Autowired
	JdbcTemplate stmt;

	public void addProfile(ProfileBean profile) {
		stmt.update("insert into profile (userid,imgurl,active) values(?,?,?)", profile.getUserId(),
				profile.getImgUrl(), profile.getActive());
	}

}
