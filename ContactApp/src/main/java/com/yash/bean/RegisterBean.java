package com.yash.bean;

import java.util.ArrayList;
 
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class RegisterBean {

	@Id
	@GeneratedValue
	private Long sl_no;
	@NotEmpty
	private String name;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	@Length(min=3)
	private String pass; 
	@Transient
	private String rpass;
	@Transient
	private MultipartFile file;
	private String imagepath;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<ContactBean> contact = new ArrayList<ContactBean>();
	public RegisterBean() {
		System.out.println("This is the RegisterBean");
	}

	public RegisterBean(@NotEmpty String name, @NotEmpty @Email String email, @NotEmpty @Length(min = 3) String pass,
			String rpass, MultipartFile file, String imagepath) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.rpass = rpass;
		this.file = file;
		this.imagepath = imagepath;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public Long getSl_no() {
		return sl_no;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPass() {
		return pass;
	}

	public String getRpass() {
		return rpass;
	}

	public void setSl_no(Long sl_no) {
		this.sl_no = sl_no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setRpass(String rpass) {
		this.rpass = rpass;
	}
	 
	public List<ContactBean> getContact() {
		return contact;
	}

	public void setContact(List<ContactBean> contact) {
		this.contact = contact;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, name, pass, rpass,imagepath);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisterBean other = (RegisterBean) obj;
		return Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(pass, other.pass) && Objects.equals(rpass, other.rpass)
				&& Objects.equals(imagepath, other.imagepath);
	}




}
