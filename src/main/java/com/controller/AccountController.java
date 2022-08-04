package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.AccountBean;
import com.bean.ExpenseBean;
import com.bean.UserBean;
import com.dao.AccountDao;
import com.dao.ExpenseDao;

@Controller
public class AccountController {

	 @Autowired
	 AccountDao accountDao;
	 
	 @Autowired
	 ExpenseDao expenseDao;
	
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
		
		if(result.hasErrors() )
		{
			model.addAttribute("accountBean",accountBean);
			return "AddAccount";
		}
		else
		{
			accountBean.setIsActive(true);
			
			
			model.addAttribute("message","added ");
			
			accountDao.accountAdded(accountBean,userId);
			return "CustomerHome";
		}
	}
	
	@GetMapping("/accountDetails")
	public String getaccountDetails(HttpSession session,Model model)
	{
		UserBean userBean=(UserBean) session.getAttribute("user");
		int userId=userBean.getUserId();
		List<AccountBean> accountBean=accountDao.getAccountDetails(userId);
		//AccountBean acc=accountDao.total(userId);
		/*
		 * int total=0; for(int i=0;i<accountBean.size();i++) { AccountBean
		 * ac=accountBean.get(i); total=total+ac.getAmmount(); }
		 * System.out.println(accountBean.toString());
		 */
		//AccountBean accountbean=new AccountBean();
		//accountbean.setTotal(total);
		//System.out.println(total);
		//System.out.println(accountBean.get(0).getCardId());
		model.addAttribute("accountBean",accountBean);
		//model.addAttribute("total",total);
		
		List<ExpenseBean> exp=expenseDao.sum(userId);
		//System.out.println(exp.get(0).getExpenseAmmount());
		
		int total=0;
		
		List<AccountBean> ac= accountDao.sum(userId);
		//System.out.println(ac.get(0).getAmmount());
		 total=ac.get(0).getAmmount()-exp.get(0).getExpenseAmmount();
		model.addAttribute("ac",ac);
		//System.out.println(total);
		model.addAttribute("total",total);
		return "AccountDetails";
	}
	@GetMapping("/addmoney")
	public String addmoney(@RequestParam("accountid") int accountId,AccountBean accountBean,Model model)
	{model.addAttribute("accountId",accountId);
		return "AddMoney";
	}
	@PostMapping("/addedmoney")
	public String addedMoney(@RequestParam("accountid") int accountId,AccountBean accountBean)
	{
		System.out.println(accountBean.getAmmount());
		List<AccountBean> ac=accountDao.getAmmountByAccountId(accountId);
		int editammount=ac.get(0).getAmmount()+accountBean.getAmmount();
		accountDao.updateMoney(accountId,editammount);
		return "CustomerHome";
	}
	
}
