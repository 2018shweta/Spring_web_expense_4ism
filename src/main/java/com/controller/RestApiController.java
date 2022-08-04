package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.AccountBean;
import com.bean.SubCategoryBean;
import com.bean.UserBean;
import com.dao.AccountDao;
import com.dao.SubCategoryDao;

@RestController
public class RestApiController {

	
	
	@Autowired
	SubCategoryDao subcategoryDao;
	
	@Autowired
	AccountDao accountDao;
	@GetMapping("/subcategories")
	public List<SubCategoryBean> getAllSubCategory(@RequestParam("categoryId") int categoryId)
	{
		List<SubCategoryBean> subCategories=subcategoryDao.getSubCategory(categoryId);
		return subCategories;
	}
	
	@GetMapping("/perCardId")
	public List<AccountBean> perCardId(HttpSession session){
		UserBean userBean=(UserBean) session.getAttribute("user");
		int userId=userBean.getUserId();
		List<AccountBean> cards=accountDao.getAccountDetails(userId);
		System.out.println(cards);
		return cards;
	}
}
