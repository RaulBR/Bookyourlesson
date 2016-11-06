package ro.bydl.domain;

import java.util.Date;

public class Student  extends Person{
	
	private Date registrationDate;
	private boolean medPaper;
	private int teacherId;
	
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public boolean isMedPaper() {
		return medPaper;
	}
	public void setMedPaper(boolean medPaper) {
		this.medPaper = medPaper;
	}
	

}
