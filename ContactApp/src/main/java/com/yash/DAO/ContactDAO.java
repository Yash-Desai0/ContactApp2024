package com.yash.DAO;

import java.util.List;

import com.yash.bean.ContactBean;

public interface ContactDAO {

	public String addContact(ContactBean bean);
	public ContactBean getContact(Long contact_sl);
	public List<ContactBean> getAllContacts(Long user_id);
	public String updateContact(ContactBean bean);
	public String deleteContact(Long contact_sl); 
	//public List<ContactBean> getAllContactDetails(String str,Long userid);
}
