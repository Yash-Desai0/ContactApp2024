package com.yash.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yash.bean.ContactBean;
import com.yash.bean.RegisterBean;
import com.yash.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	ContactService service;
	
	public ContactController() {
		System.out.println("This is the ContactController");
	}
	
	@RequestMapping("/dashboard")
	public String showDashboard(Model m,HttpSession session)
	{
		RegisterBean bean = (RegisterBean) session.getAttribute("UserBean");
		System.out.println(bean.getSl_no());
		m.addAttribute("Contacts",service.getAllContacts(bean.getSl_no()));
		return "Menu";
	}
	
	@RequestMapping("/viewcontacts/{pageid}")
	public String viewContactBypage(@PathVariable(value="pageid") int pageid,Model m,HttpSession session)
	{
		RegisterBean bean = (RegisterBean) session.getAttribute("UserBean");
		m.addAttribute("Contacts",service.getAllContactsByPageId(pageid, bean.getSl_no()));
		m.addAttribute("count", service.getContactsCount(bean.getSl_no())); 
		return "AllContacts";
	}
	
	@RequestMapping("/openAddContactView")
	public String openContactForm(Model m)
	{
		ContactBean bean = new ContactBean();
		m.addAttribute("con", bean);
		return "Contact";
	}
	 
	@RequestMapping("/SearchContact")
	public String SearchedContacts(@RequestParam("str") String str , Model m, HttpSession session)
	{
		RegisterBean reg = (RegisterBean) session.getAttribute("UserBean");
		Long userid = reg.getSl_no();
		System.out.println(userid); 
		System.out.println(str);
		 
		if(str.equals(null))
		{
			m.addAttribute("NotFound","Records Not Found");
			return "Menu";
		}
		else
		{
			
			List<ContactBean> contacts = service.getAllContactsDetails(str,userid);
			if(contacts==null || contacts.isEmpty())
			{
				m.addAttribute("NotFound","Records Not Found");
				return "Menu";
			}
			else
			{
				m.addAttribute("Contacts",contacts);
				System.out.println(contacts);
				return "Menu"; 
			} 			  	
		} 
	}
	
	@RequestMapping("/openEditContactView/{contact_sl}")
	public String EditForm(@PathVariable(value="contact_sl")Long contact_sl,Model m)
	{
		ContactBean bean = new ContactBean();
		m.addAttribute("Edit",bean);
		m.addAttribute("Contact",service.getContact(contact_sl));
		return "EditContact";
	}
	
	@RequestMapping("/addContact")
	public String AddContact(@ModelAttribute("con") @Valid ContactBean bean,BindingResult result,Model m)
	{
		if(result.hasErrors())
		{
			m.addAttribute("errorMsg","AddContact Page Error : "+result);
			return "Error";
		}
		System.out.println("before");
		System.out.println(bean.getContact_sl());
		String msg = service.AddContact(bean);
		System.out.println(bean.getContact_sl());
		if(msg.equals("success"))
		{
			m.addAttribute("NotFound","Contact Add Successfully.");
			return "redirect:/dashboard";
		}
		else
		{
			m.addAttribute("errorMsg",msg);
			return "Contact";
		} 
	}
	
	@RequestMapping("/deleteContact/{contact_sl}")
	public String deleteContact(@PathVariable(value = "contact_sl") Long contact_sl,Model m)
	{ 
		System.out.println(contact_sl);
		String msg = service.deleteContact(contact_sl);
		if(msg.equals("success"))
		{
		 	m.addAttribute("NotFound","Deleted Successfully.");
			return "redirect:/dashboard";
		}
		else
		{
			m.addAttribute("errorMsg",msg);
			return "Error";
		} 	 
	}
	
	@RequestMapping("/openEditContactView/updateContact")
	public String updateContact(@ModelAttribute("Edit") @Valid ContactBean bean,BindingResult result,Model m)
	{ 
		if(result.hasErrors())
		{
			m.addAttribute("errorMsg","UpdateContact Page Error : "+result);
			return "Error";
		}
		
		System.out.println(bean);
		String msg = service.updateContact(bean);
		
		if(msg.equals("success"))
		{
			m.addAttribute("success","Contact Edited Successfully.");
			return "redirect:/dashboard";
		}
		else
		{
			m.addAttribute("errorMsg",msg);
			return "Contact";
		} 
	}
}
