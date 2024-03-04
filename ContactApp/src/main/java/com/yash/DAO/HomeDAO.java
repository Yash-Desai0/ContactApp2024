package com.yash.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.bean.ContactBean;
import com.yash.bean.LoginBean;
import com.yash.bean.RegisterBean;

@Repository
public class HomeDAO {

	@Autowired
	SessionFactory factory;
	
	public HomeDAO() {
		System.out.println("This is Repository");
	}

	private Session s;
	private Transaction t; 
	private RegisterBean bean;
	
	public String Register(RegisterBean bean) {
		try {
			s = factory.openSession();
			t = s.beginTransaction();
			
			Long pk = (Long)s.save(bean);
			
			if(pk!=null)
			{
				System.out.println("Primary key is "+pk);
				return "success";
			} 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
		finally
		{
			t.commit();
			s.close();
		}
		return "Not Registered !!!";
	 
	}
	
	public boolean isEmailRegistered(String email)
	{ 
		try {
			s = factory.openSession();
			t = s.beginTransaction();
			
			bean = (RegisterBean) s.createQuery("from RegisterBean where email= :email").setParameter("email", email).uniqueResult();
			 
			if(bean!=null)
			{
				return false;
			} 
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		finally
		{
			t.commit();
			s.close();
		}
		return true;
	}

	public RegisterBean Login(LoginBean bean) { 
		try {
			s = factory.openSession();
			t = s.beginTransaction();
			
			this.bean = (RegisterBean) s.createQuery("from RegisterBean where email= :email AND pass= :password").setParameter("email", bean.getEmail()).setParameter("password", bean.getPass()).uniqueResult();
		 	
			if(this.bean!=null)
			{
				 return this.bean;
			} 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			t.commit();
			s.close();
		}
		return null;
	}

	public String saveContactDetails(ContactBean bean) {
		try {
			s = factory.openSession();
			t = s.beginTransaction();
			
			Long pk = (Long)s.save(bean);
			
			if(pk!=null)
			{
				System.out.println("Primary key is "+pk);
				return "success";
			} 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
		finally
		{
			t.commit();
			s.close();
		}
		return "Not Added !!!";
	}

	public String updateContact(RegisterBean bean) {
		try {
			s = factory.openSession();
			t = s.beginTransaction();
			
			s.update(bean);
			return "success";
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
		finally
		{
			t.commit();
			s.close();
		} 
	}

	@SuppressWarnings("unchecked")
	public List<ContactBean> getAllContacts() {
		
		try {
			s = factory.openSession();
			t = s.beginTransaction();
			
			List<ContactBean> beans  = s.createQuery("from ContactBean").getResultList();
			return beans;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			t.commit();
			s.close();
		} 
		return null;
	}

	public String DeleteContact(Long contact_sl) {
		try {
			s = factory.openSession();
			t = s.beginTransaction();
			
			ContactBean contact = s.get(ContactBean.class, contact_sl);
			
			if(contact!=null)
			{
				s.delete(contact);
				return "success";
			}
				
			else
				return "There is not Contact Details";
			
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
		finally
		{
			t.commit();
			s.close();
		} 
	}

}
