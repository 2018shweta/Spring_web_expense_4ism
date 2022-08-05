package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.CategoryBean;
import com.bean.SubCategoryBean;
import com.bean.UserBean;
import com.dao.CategoryDao;
import com.dao.SubCategoryDao;

@Controller
public class SubCategoryController {
	@Autowired
	SubCategoryDao subCategoryDao;
	@Autowired
	CategoryDao categoryDao;
	@GetMapping("/addsubcategory")
	public String subcategory(Model model,CategoryBean categoryBean,HttpSession session)
	{ UserBean userBean=(UserBean) session.getAttribute("user");
	int userId=userBean.getUserId();
		SubCategoryBean subCategoryBean =new SubCategoryBean();
	model.addAttribute("subCategoryBean",subCategoryBean);
	
	List<CategoryBean> category=categoryDao.allCategory( userId);
	model.addAttribute("category",category);
		return "AddSubCategory";
	}
	@PostMapping("/subcategoryadded")
	public String  subcategoryadded(@ModelAttribute("subCategoryBean") SubCategoryBean subCategoryBean,Model model,BindingResult result,HttpSession session)
	{   UserBean userBean=(UserBean) session.getAttribute("user");
		int userId=userBean.getUserId();
		if(result.hasErrors())
		{
			model.addAttribute("subcategoryBean",subCategoryBean);
			return "AddSubCategory";
		}
		else {
			
			model.addAttribute("msg","subcategory added");
			subCategoryDao.subCategoryAdded(subCategoryBean,userId);
			return "CustomerHome";
		}
	}
	@GetMapping("/categorychart")
	public String categorychart(HttpSession session)
	{
		UserBean userBean=(UserBean) session.getAttribute("user");
		int userId=userBean.getUserId();
		
	}
	
}
