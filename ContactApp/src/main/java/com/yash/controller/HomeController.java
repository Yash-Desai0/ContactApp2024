package com.yash.controller;
  
import java.util.List; 
import javax.servlet.http.HttpSession;
import javax.validation.Valid; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.multipart.MultipartFile; 
import com.yash.bean.ContactBean;
import com.yash.bean.LoginBean;
import com.yash.bean.RegisterBean;
import com.yash.service.HomeService;
import com.yash.util.FileUpload;
 

@Controller
public class HomeController {

	@Autowired
	HomeService service;
	
	public HomeController() {
		System.out.println("This is Controlller...");
	}

	@RequestMapping({"/","/home"})
	public String HomePage()
	{
		return "HomePage";
	}
	
	@RequestMapping("/openRegisterView")
	public String RegisterPage(Model m)
	{
		RegisterBean bean = new RegisterBean();
		m.addAttribute("reg", bean);
		return "Register";
	}
		
	@RequestMapping("/Register")
	public String Register(@ModelAttribute("reg") @Valid RegisterBean bean,BindingResult result,Model m) 
	{
		if(result.hasErrors())
		{
			m.addAttribute("erorMsg", result);
			return "Register";
		} 
		
		MultipartFile file = bean.getFile();
		System.out.println(file);
		if(file.isEmpty())
		{
			bean.setImagepath("resources/image/default.png");
		}
		else
		{
			bean.setImagepath(FileUpload.getFileLocation(file,bean.getName()));
		}
		
		 
		
		if(!service.checkEmail(bean.getEmail()))
		{
			m.addAttribute("errorMsg", "User already Registered.");
			return "Register";
		}
		
		String msg = service.RegisterUser(bean);
		
		if(msg.equals("success"))
		{
			m.addAttribute("HomeMsg","Registered Successfully !!");
			return "HomePage";
		}
		else
		{
			m.addAttribute("errorMsg", msg);
			return "Register";
		} 
	}
	
	@RequestMapping("/openLoginView")
	public String LoginPage(Model m)
	{
		LoginBean bean = new LoginBean();
		m.addAttribute("log", bean);
		return "Login";
	}
	
	@RequestMapping("/Login")
	public String Login(@ModelAttribute("log") @Valid LoginBean bean ,BindingResult result,Model m,HttpSession session)
	{
		if(result.hasErrors())
		{
			m.addAttribute("errorMsg", result);
			return "Login";
		}
		
		if(service.checkEmail(bean.getEmail()))
		{
			m.addAttribute("HomeMsg", "You are not Registred in our System.");
			return "HomePage";
		}
		
		RegisterBean userbean = service.LoginUser(bean);
		List<ContactBean> Contacts = service.getAllContacts();
		
		if(userbean!=null)
		{
			session.setAttribute("UserBean", userbean);
			session.setMaxInactiveInterval(10*60); 
			return "redirect:/dashboard";
		}
		else
		{
			m.addAttribute("errorMsg", "Invalid Password.");
			return "Login";
		} 
	}
	
	@RequestMapping("/logout")
	public String Logout(HttpSession session,Model m)
	{
		session.invalidate();
		m.addAttribute("HomeMsg","Loogut Successful.");
		return "HomePage";
	}
	 
	@RequestMapping("/openProfileView")
	public String openProfile(Model m)
	{
		RegisterBean bean = new RegisterBean();
		m.addAttribute("temp", bean);
		return "Profile";
	}
	
	@RequestMapping("/editProfile")
	public String EditProfile(@ModelAttribute("temp") @Valid RegisterBean bean,BindingResult result,Model m,HttpSession session)
	{
		System.out.println(bean.getEmail());
		System.out.println(bean.getImagepath());
		System.out.println(bean.getName());
		System.out.println(bean.getPass());
		System.out.println(bean.getFile());
		 
		if(result.hasErrors())
		{
			m.addAttribute("errorMsg", "EditProfile Error : "+result.toString());
			return "Error";
		}
		
		MultipartFile file = bean.getFile();

		if(file.isEmpty() && bean.getImagepath().contains("default"))
		{
			bean.setImagepath("resources/image/default.png");
		}
		else
		{
			bean.setImagepath(FileUpload.getFileLocation(file,bean.getName()));
		}
			
		System.out.println(bean);
		String msg = service.EditProfile(bean);
		if(msg.equals("success"))
		{
			session.setAttribute("UserBean", bean);
			m.addAttribute("success","Profile Update Successfully.");
			return "redirect:/dashboard";
		}
		else
		{
			m.addAttribute("errorMsg",msg);
			return "Profile";
		}
	}
 	
}
