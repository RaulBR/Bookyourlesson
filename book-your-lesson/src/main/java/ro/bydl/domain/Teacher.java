package ro.bydl.domain;

public class Teacher extends Person {

	private String hireDate;
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
