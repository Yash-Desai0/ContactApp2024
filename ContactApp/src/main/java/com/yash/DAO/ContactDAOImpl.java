package com.yash.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.bean.ContactBean;

@Repository
public class ContactDAOImpl implements ContactDAO{

	@Autowired
	SessionFactory f;
	
	private Session s;
	private Transaction t;
	
	@Override
	public String addContact(ContactBean bean) {
		try {
			s = f.openSession();
			t = s.beginTransaction();
			
			Long pk = (Long)s.save(bean);
			
			if(pk!=null)
			{
				System.out.println("This is Generated Primary Key:"+pk);
				return "success";
			} 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
		finally {
			t.commit();
			s.close();
		} 
		return null;
	}

	@Override
	public ContactBean getContact(Long contact_sl) {
		try {
			s = f.openSession();
			t = s.beginTransaction();
			
			ContactBean contact= s.get(ContactBean.class,contact_sl);
			
			if(contact!=null)
				return contact;  
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		finally {
			t.commit();
			s.close();
		} 
		return null;
	}

	@Override
	public List<ContactBean> getAllContacts(Long userid) {
		try {
			s = f.openSession();
			t = s.beginTransaction();
			
			@SuppressWarnings("unchecked")
			List<ContactBean> contacts = s.createQuery("from ContactBean where user.sl_no = :id").setParameter("id", userid).getResultList();
			
			if(!contacts.isEmpty())
				return contacts; 
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		finally {
			t.commit();
			s.close();
		} 
		return null;
	}

	@Override
	public String updateContact(ContactBean bean) {
		try {
			s = f.openSession();
			t = s.beginTransaction(); 
			
			s.update(bean);
			return "success"; 
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
			return e.getMessage();
		}
		finally {
			t.commit();
			s.close();
		} 
	}

	@Override
	public String deleteContact(Long contact_sl) {
		try {
			s = f.openSession();
			t = s.beginTransaction();
			
			ContactBean contact = s.get(ContactBean.class,contact_sl);
			
			if(contact!=null)
			{
				 s.delete(contact);
				return "success";
			}
			else
			{
				return "Whatever you want to delete that is not exiest.";
			} 
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
			return e.getMessage();
		}
		finally {
			t.commit();
			s.close();
		} 
	}

//	@Override
//	public List<ContactBean> getAllContactDetails(String str) {
//		try {
//			s = f.openSession();
//			t = s.beginTransaction();
//			
//			List<ContactBean> beans = getAllContacts(userid);
//			
//			@SuppressWarnings("unchecked")
//			List<ContactBean> contacts =  s.createQuery("from ContactBean where name like ?1 or email like ?1 or tag like ?1").setParameter(1, "%"+str+"%").getResultList();
//			
//			if(!contacts.isEmpty())
//				return contacts; 
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace(); 
//		}
//		finally {
//			t.commit();
//			s.close();
//		} 
//		return null;
//	}

	 

}
