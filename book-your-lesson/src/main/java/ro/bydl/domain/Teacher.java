package ro.bydl.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class Teacher extends Person {
	@NotEmpty
	private String hireDate;
	@NotEmpty
	private String medDate;

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getMedDate() {
		return medDate;
	}

	public void setMedDate(String medDate) {
		this.medDate = medDate;
	}

}
