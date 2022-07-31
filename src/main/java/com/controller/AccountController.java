package com.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.AccountBean;
import com.bean.UserBean;
import com.dao.AccountDao;

@Controller
public class AccountController {

	 @Autowired
	 AccountDao accountDao;
	
	@GetMapping("/addaccount")
	public String addAccount(Model model)
	{
		AccountBean accountBean=new AccountBean();
		model.addAttribute("accountBean",accountBean);
		return "AddAccount";
	}
	@PostMapping("/accountadded")
	public String accountAdded(@ModelAttribute("accountBean") @Valid AccountBean accountBean,BindingResult result,Model model,HttpSession session)
	{
		 UserBean user=(UserBean)session.getAttribute("user");
		  int userId=user.getUserId();
		System.out.println(userId);
		System.out.println(accountBean.getAccountType());
		System.out.println(accountBean.getAmmount());
		System.out.println(result);
		if(result.hasErrors())
		{
			model.addAttribute("accountBean",accountBean);
			return "AddAccount";
		}
		else
		{
			model.addAttribute("message","added ");
			
			accountDao.accountAdded(accountBean,userId);
			return "CustomerHome";
		}
	}
	
	
}
