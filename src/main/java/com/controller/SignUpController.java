package com.controller;

import javax.naming.Binding;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.LoginBean;
import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SignUpController {

	@Autowired
	UserDao userDao;
	
	
	@GetMapping("/signup")
	public String signUp(Model model)
	{  UserBean userBean=new UserBean();
	  model.addAttribute("userBean",userBean);
		return "SignUp";
	}
	@PostMapping("/saveuser")
	public String saveuser(@ModelAttribute("userBean")@Valid UserBean userBean ,Model model,BindingResult result)
	{  if(result.hasErrors())
	{
		model.addAttribute("userBean",userBean);
		return "SignUp";
	}
	else {
		
		userBean.setIsActive(true);
		userBean.setUserType("customer");
		System.out.println(userBean.getFirstName());
		model.addAttribute("message","signup success");
		userDao.addUsers(userBean);
		System.out.println(userBean.getFirstName());
		return "Login";
	}
	}

	@GetMapping("/login")
	public String login()
	{
		return "Login";
	}
	
	@PostMapping("/loginuser")
	
	public String loginuser(LoginBean loginBean,HttpSession session)
	{
		
		UserBean userBean=userDao.loginUser(loginBean);
		session.setAttribute("user", userBean);
		if(userBean==null)
		{
			return "Login";
		}
		else {
			if(userBean.getUserType().contentEquals("admin")&& userBean.getIsActive()==true)
			{
				return "AdminHome";
			}
			else if(userBean.getUserType().contentEquals("customer")&& userBean.getIsActive()==true)
			{
				return "CustomerHome";
			}
			else
			{
				return "Login";
			}
			
	
		}
		
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "Login";
	}
	
}
