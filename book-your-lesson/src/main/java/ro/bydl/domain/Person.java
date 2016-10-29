package ro.bydl.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class Person extends AbstractModel {
	@NotEmpty
	private String name;
	@NotEmpty
	private String sirName;

	private long cnp;
	@NotEmpty
	private String category;

	private long phoneNumber;
	@NotEmpty
	private String email;
	@NotEmpty
	private String birthday;

	public String getBirthDay() {
		return birthday;
	}

	public void setBirthDay(String birthDay) {
		this.birthday = birthDay;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
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

	public long getCnp() {
		return cnp;
	}

	public void setCnp(long cnp) {
		this.cnp = cnp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cnp ^ (cnp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (cnp != other.cnp)
			return false;
		return true;
	}

}
