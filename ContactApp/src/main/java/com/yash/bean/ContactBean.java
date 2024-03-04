package com.yash.bean;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ContactBean {

	@Id
	@GeneratedValue
	private Long contact_sl;
	
	@ManyToOne
	private RegisterBean user;
	
	private String name;
	private String email;
	private String tag;
	private Gender gender;
	
	public ContactBean() {
		System.out.println("This is ContactBean..");
	}

	public ContactBean(String name, String email, String tag, Gender gender) {
		super();
		this.name = name;
		this.email = email;
		this.tag = tag;
		this.gender = gender;
		System.out.println(this.gender);
	}

	public Long getContact_sl() {
		return contact_sl;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getTag() {
		return tag;
	}

	public Gender getGender() {
		return gender;
	}

	public void setContact_sl(Long contact_sl) {
		this.contact_sl = contact_sl;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	 
	public RegisterBean getUser() {
		return user;
	}

	public void setUser(RegisterBean user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, gender, name, tag);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactBean other = (ContactBean) obj;
		return Objects.equals(email, other.email) && gender == other.gender && Objects.equals(name, other.name)
				&& Objects.equals(tag, other.tag);
	}

	@Override
	public String toString() {
		return "ContactBean [contact_sl=" + contact_sl + ", user=" + user + ", name=" + name + ", email=" + email
				+ ", tag=" + tag + ", gender=" + gender + "]";
	}

 	 
 
	
}

enum Gender{
	male,female
}
