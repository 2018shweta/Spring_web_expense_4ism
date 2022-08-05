package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.CategoryBean;
import com.bean.UserBean;
import com.dao.CategoryDao;

@Controller
public class CategoryController {

	
	@Autowired
	CategoryDao categoryDao;
	
	
	@GetMapping("/addcategory")
	public String addCategory(Model model)
	{ CategoryBean categoryBean=new CategoryBean();
	model.addAttribute("categoryBean",categoryBean);
		return "AddCategory";
	}
	
	@PostMapping("/categoryadded")
	public String categoryadded(@ModelAttribute("categoryBean") CategoryBean categoryBean,BindingResult result,Model model,HttpSession session)
	{
		UserBean userBean=(UserBean) session.getAttribute("user");
		int userId=userBean.getUserId();
		if(result.hasErrors())
		{
			
			model.addAttribute("categoryBean",categoryBean);
			return "AddCategory";
		}
		else {
			model.addAttribute("msg","category added");
			categoryDao.addCategory(categoryBean,userId);
			
			
			if(userBean.getUserType().contentEquals("admin"))
			{
				return "AdminHome";
			}
			else {
			return "CustomerHome";
		}
			}
	}
	
	
}
