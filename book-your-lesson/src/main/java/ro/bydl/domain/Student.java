package ro.bydl.domain;

public class Student  extends Person{
	
	String registrationDate;
	boolean psihoTest;
	boolean medPaper;
	boolean record;
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
	public boolean isPsihoTest() {
		return psihoTest;
	}
	public void setPsihoTest(boolean psihoTest) {
		this.psihoTest = psihoTest;
	}
	public boolean isMedPaper() {
		return medPaper;
	}
	public void setMedPaper(boolean medPaper) {
		this.medPaper = medPaper;
	}
	public boolean isRecord() {
		return record;
	}
	public void setRecord(boolean record) {
		this.record = record;
	}

}
