package ro.bydl.domain;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Teacher extends Person {
	@NotEmpty
	private Date hireDate;
	@NotEmpty
	private String medDate;

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getMedDate() {
		return medDate;
	}

	public void setMedDate(String medDate) {
		this.medDate = medDate;
	}

}
