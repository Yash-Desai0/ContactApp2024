package com.yash.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.DAO.HomeDAO;
import com.yash.bean.ContactBean;
import com.yash.bean.LoginBean;
import com.yash.bean.RegisterBean;

@Service
public class HomeService {

	@Autowired
	HomeDAO dao;
	
	public HomeService() {
		System.out.println("This is Services..");
	}

	public String RegisterUser(RegisterBean bean) { 
		return dao.Register(bean);
	}

	public RegisterBean LoginUser(LoginBean bean) { 
		return dao.Login(bean);
	}

	public boolean checkEmail(String email) { 
		return dao.isEmailRegistered(email);
	}

	public String AddContact(ContactBean bean) { 
		return dao.saveContactDetails(bean);
	}

	public String EditProfile(RegisterBean bean) {
		return dao.updateContact(bean);
	}

	public List<ContactBean> getAllContacts() { 
		return dao.getAllContacts();
	}

	public String deleteContact(Long contact_sl) {
		// TODO Auto-generated method stub
		return dao.DeleteContact(contact_sl);
	}

}
