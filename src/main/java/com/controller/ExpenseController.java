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
import com.bean.CategoryBean;
import com.bean.ExpenseBean;
import com.bean.UserBean;
import com.dao.AccountDao;
import com.dao.CategoryDao;
import com.dao.ExpenseDao;

@Controller
public class ExpenseController {

	@Autowired
	ExpenseDao expenseDao;
	@Autowired
	AccountDao accountDao;
	@Autowired
	CategoryDao categoryDao;

	@GetMapping("/expense")
	public String expense(Model model, CategoryBean categoryBean, HttpSession session) {
		ExpenseBean expenseBean = new ExpenseBean();
		UserBean userBean = (UserBean) session.getAttribute("user");
		int userId = userBean.getUserId();
		// CategoryBean categoryBean=new CategoryBean();
		List<CategoryBean> category = categoryDao.allCategory(userId);
		model.addAttribute("category", category);
		model.addAttribute("expenseBean", expenseBean);
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
		//System.out.println(expenseBean.getCategoryName());
		//System.out.println(expenseBean.getTypeOfPayment());
		
		 List<AccountBean> acBean=accountDao.getAccountDetails(userId);
		 System.out.println(acBean.get(0).getAccountType());
		 System.out.println(acBean.get(0).getAmmount());
		 int acid=Integer.parseInt(expenseBean.getTypeOfPayment());
			int fAm=0;
			boolean flag=false;
			  for (int i=0;i<acBean.size();i++) { //
			  if(acid==acBean.get(i).getAccountId() && expenseBean.getExpenseAmmount()<acBean.get(i).getAmmount()) {
			     fAm= acBean.get(i).getAmmount()-expenseBean.getExpenseAmmount();
			     
			     int acId=acBean.get(i).getAccountId();
			     accountDao.updatedfAm(acId,fAm);
			     expenseDao.addExpense(expenseBean,userId);
			     //return "CustomerHome";
			     flag=true;
			     
			  }
			  
			  
			  }
			 
			 if(flag)
			 {
				 return "CustomerHome";
			 }
			 else {
				return "redirect:/expense"; 
			 }
			 
			 
		//expenseDao.addExpense(expenseBean,userId);
		//return "CustomerHome";
		
	}
		
	}

	@GetMapping("/expenselist")
	public String allExpenseList(HttpSession session, Model model) {
		UserBean userBean = (UserBean) session.getAttribute("user");
		int userId = userBean.getUserId();
		List<ExpenseBean> expense = expenseDao.allExpenseList(userId);
		model.addAttribute("expense", expense);
		return "AllExpenseList";
	}

	@GetMapping("/deleteexpense")
	public String deleteExpense(@RequestParam("expenseid") int expenseId, HttpSession session) {
		UserBean userBean = (UserBean) session.getAttribute("user");
		int userId = userBean.getUserId();
		System.out.println(expenseId);
		System.out.println(userId);
		expenseDao.deleteExpense(expenseId);
		return "redirect:/expenselist";
	}

	@GetMapping("/updateexpense")
	public String updateExpense(@RequestParam("expenseid") int expenseId, Model model) {
		ExpenseBean expense = expenseDao.getExpenseByExpenseId(expenseId);
		model.addAttribute("expense", expense);
		return "EditExpense";
	}

	@PostMapping("/expenseedit")
	public String editExpense(ExpenseBean expenseBean, HttpSession session) {
		expenseDao.updateExpense(expenseBean);
		System.out.println(expenseBean.getExpenseId());
		return "redirect:/expenselist";
	}

}
