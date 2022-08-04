package com.bean;

public class ExpenseBean {

	
	Integer expenseId;
	Integer userId;
	Integer categoryId;
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	Integer subCategoryId;
	public Integer getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	Integer acId;
	public Integer getAcId() {
		return acId;
	}
	public void setAcId(Integer acId) {
		this.acId = acId;
	}
	String categoryName;
	String date;
	String time;
	String description;
	Integer expenseAmmount;
	String typeOfPayment;
	public Integer getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getExpenseAmmount() {
		return expenseAmmount;
	}
	public void setExpenseAmmount(Integer expenseAmmount) {
		this.expenseAmmount = expenseAmmount;
	}
	public String getTypeOfPayment() {
		return typeOfPayment;
	}
	public void setTypeOfPayment(String typeOfPayment) {
		this.typeOfPayment = typeOfPayment;
	}
	
	
}
