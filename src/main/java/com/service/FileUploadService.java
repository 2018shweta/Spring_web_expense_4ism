package com.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

public void imgUpload(MultipartFile file,int userId) {
		
		
		try {
			String mainPath="C:\\Users\\Dell\\Documents\\workspace-spring-tool-suite-4-4.15.1.RELEASE\\Exp_Tra\\src\\main\\resources\\static\\images";
			File folder=new File(mainPath,userId+"");
			folder.mkdir();
			File newFile=new File(folder,file.getOriginalFilename());
			byte b[]=file.getBytes();
			FileOutputStream fos=new FileOutputStream(newFile);
			fos.write(b);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
