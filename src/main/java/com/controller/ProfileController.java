package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.ProfileBean;
import com.bean.UserBean;
import com.dao.ProfileDao;
import com.service.FileUploadService;

@Controller
public class ProfileController {

	
	@Autowired
	ProfileDao profileDao;
	
	@Autowired
	FileUploadService fileUploadService;
	
	@GetMapping("/newprofile")
	public String newProfile() {
		return "NewProfile";
	}

	@PostMapping("/saveprofile")
	public String saveProfile(@RequestParam("profile") MultipartFile file, HttpSession session) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());

		UserBean user = (UserBean) session.getAttribute("user");
		int userId = user.getUserId();

		fileUploadService.imgUpload(file, userId);
		ProfileBean profile = new ProfileBean();
		profile.setUserId(userId);
		profile.setImgUrl("resources\\images" +"\\"+ userId + "\\" + file.getOriginalFilename());
		profile.setActive(true);
		profileDao.addProfile(profile);

		return "NewProfile";
	}
	
	
	
	
	
}
