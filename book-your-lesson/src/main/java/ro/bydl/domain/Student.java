package ro.bydl.person;

import java.util.ArrayList;
import java.util.Date;

public class Student extends Person {

	/**
	 * The "Category" is an enum by category ,the categories available are A,B,C
	 * The "nrHoursUse" field represent number the hours use by the student The
	 * "startDate" represent the start date when the student start the school
	 * The "age" represent the age of student .
	 */
	private Category category;
	int nrHoursUse;
	private Date startDate;
	private int age;
	protected String userName;
	protected String password;

	/**
	 * This method valid if student has the age correct for the category
	 * 
	 * @return
	 */

	public boolean validAgeForCategory() {
		Category A = Category.A;
		Category B = Category.B;
		Category C = Category.C;

		if ((A == Category.A) && (getAge() <= 24))
			return false;
		if ((B == Category.B) && (getAge() <= 18))
			return false;
		if ((C == Category.C) && (getAge() <= 21))
			return false;

		return true;

	}

	/**
	 * This method add the Students in an ArrayList
	 * 
	 * @param s
	 */

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setNrHoursUse(int nrHoursUse) {
		this.nrHoursUse = nrHoursUse;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Category getCategory() {
		return category;
	}

	public int getNrHoursUse() {
		return nrHoursUse;
	}

	public Date getStartDate() {
		return startDate;
	}

}
