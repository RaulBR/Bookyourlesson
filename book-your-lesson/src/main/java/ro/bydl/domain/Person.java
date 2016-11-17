package ro.bydl.domain;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Person extends User {
	@NotEmpty
	private String name;
	@NotEmpty
	private String sirName;
	@NotEmpty
	private String cnp;
	@NotEmpty
	private String category;
	@NotEmpty
	private String phoneNumber;
	@NotEmpty
	private String email;

	private Date birthday;

	public Date getBirthDay() {
		return birthday;
	}

	public void setBirthDay(Date birthDay) {
		this.birthday = birthDay;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSirName() {
		return sirName;
	}

	public void setSirName(String sirName) {
		this.sirName = sirName;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

}
