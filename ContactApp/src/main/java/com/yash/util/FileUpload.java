package com.yash.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

	public FileUpload() {
		System.out.println("This is the File Upload part.");
	}
	
	public static String getFileLocation(MultipartFile part,String uname)  
	{
		String path = "resources/image/";
		String filename = uname+".png";
		
		System.out.println(filename);
		
		File file = new File("C:\\Users\\yashd\\eclipse-workspace\\Contact\\src\\main\\webapp\\resources\\image\\" + filename);
		  
		try (FileOutputStream os = new FileOutputStream(file)) 
		{
		    os.write(part.getBytes());
		}catch (IOException e) 
		{ 
			e.printStackTrace();
		}
		
		return path+filename; 	
	}
	
	 

}
