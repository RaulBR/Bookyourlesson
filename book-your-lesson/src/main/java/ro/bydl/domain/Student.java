package ro.bydl.domain;

public class Student  extends Person{
	
	private String registrationDate;
	private boolean medPaper;
	private int teacherId;
	
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public boolean isMedPaper() {
		return medPaper;
	}
	public void setMedPaper(boolean medPaper) {
		this.medPaper = medPaper;
	}
	

}
