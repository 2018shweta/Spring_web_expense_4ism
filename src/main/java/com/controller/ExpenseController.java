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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.ExpenseBean;
import com.bean.UserBean;
import com.dao.ExpenseDao;

@Controller
public class ExpenseController {

	@Autowired
	ExpenseDao expenseDao ;
	
	@GetMapping("/expense")
	public String expense(Model model)
	{   ExpenseBean expenseBean=new ExpenseBean();
		model.addAttribute("expenseBean",expenseBean);
		return "AddExpense";
	}
	
	@PostMapping("/expenseadded")
	public String expenseadded(@ModelAttribute("expenseBean") @Valid ExpenseBean expenseBean,BindingResult result,Model model,HttpSession session)
	{     UserBean userBean=(UserBean)session.getAttribute("user");
	int userId=userBean.getUserId();
	if(result.hasErrors())
	{
		model.addAttribute("expenseBean",expenseBean);
		return "AddExpense";
	}else
	{
		model.addAttribute("message","added");
		//expenseBean.setUserId(userBean.getUserId());
		expenseDao.addExpense(expenseBean,userId);
		return "CustomerHome";
		
	}
		
	}
	 @GetMapping("/expenselist")
	 public String allExpenseList(HttpSession session,Model model)
	 {
		 UserBean userBean=(UserBean)session.getAttribute("user");
			int userId=userBean.getUserId();
		List<ExpenseBean> expense= expenseDao.allExpenseList(userId);
		 model.addAttribute("expense",expense);
		 return "AllExpenseList";
	 }
	 @GetMapping("/deleteexpense")
	 public String deleteExpense(@PathVariable("expenseid") int expenseId,HttpSession session)
	 {
		 UserBean userBean=(UserBean)session.getAttribute("user");
		 int userId=userBean.getUserId();
		 System.out.println(expenseId);
		 expenseDao.deleteExpense(expenseId,userId);
		 return "redirect:/expenselist";
	 }
	
	
	
	
}
