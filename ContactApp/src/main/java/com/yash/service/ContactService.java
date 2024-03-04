package com.yash.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.DAO.ContactDAO;
import com.yash.bean.ContactBean;

@Service
public class ContactService {

	 @Autowired
	 ContactDAO dao;
	
	 public String AddContact(ContactBean bean)
	 {
		 return dao.addContact(bean);
	 }

	 public String deleteContact(Long id)
	 {
		 return dao.deleteContact(id); 
	 }
	 
	 public List<ContactBean> getAllContacts(Long id)
	 {
		 return dao.getAllContacts(id);
	 }
	 
	 public ContactBean getContact(Long id)
	 {
		 return dao.getContact(id);
	 }
	 
	 public String updateContact(ContactBean bean)
	 {
		 return dao.updateContact(bean);
	 }
	 
	 public List<ContactBean> getAllContactsDetails(String str,Long userid) // Search functionality
	 {
		 
		 List<ContactBean> contacts = dao.getAllContacts(userid);
		 List<ContactBean> FilteredContact = null;
		 if(contacts == null || contacts.isEmpty())
		 {
			 return null;
		 } 
		 else
		 {
			 FilteredContact = new ArrayList<ContactBean>();
			 for(ContactBean contact:contacts)
			 {
				 if(contact.getName().contains(str) || contact.getEmail().contains(str) || contact.getTag().contains(str))
				 {
					FilteredContact.add(contact);
				 }
			 }
		 }
		 if(FilteredContact==null || FilteredContact.isEmpty())
			 return null;
		 else
			 return FilteredContact;
	 }
	 
	  
	@SuppressWarnings("null")
	public List<ContactBean> getAllContactsByPageId(int pageid,Long userid)
	 {
		 List<ContactBean> contacts = dao.getAllContacts(userid);
		 List<ContactBean> requiredContacts = null;
		 if(contacts == null || contacts.isEmpty())
		 {
			 return null;
		 } 
		 else
		 {
			int destination = 5;
			int HowManyContacts = contacts.size();
			 if(pageid==1)
			 {
//				 for(int i=0;i<destination;i++)
//				 {
					 requiredContacts.addAll(contacts);
//				 } 
			 }
			 else
			 {
				 int from = (pageid-1)*destination; 	//pageid = 1	0,5   2   5,5	3	10,5  4  15,5    5  20,5
				 for(int i=from;i<destination;i++)
				 {
					requiredContacts.add(contacts.get(i)); 
				 } 
			 }
			 return requiredContacts; 
		 } 
	 }
	 
	 public int getContactsCount(Long userid)
	 {
		 List<ContactBean> contacts = dao.getAllContacts(userid);
		 if(contacts == null || contacts.isEmpty())
		 {
			 return 0;
		 }
		 else
		 {
			 return contacts.size();
		 } 
	 }
}

