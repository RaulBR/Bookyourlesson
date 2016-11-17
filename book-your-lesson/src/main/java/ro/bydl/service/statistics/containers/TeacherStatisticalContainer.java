package ro.bydl.service.statistics.containers;

import ro.bydl.domain.Teacher;

public class TeacherStatisticalContainer extends PersonStatisticContainer<Teacher>  
implements Comparable<TeacherStatisticalContainer>{
	
	private long numberOfStudents;
	private long	numberOfCars;
	public long getNumberOfCars() {
		return numberOfCars;
	}
	public void setNumberOfCars(long numberOfCars) {
		this.numberOfCars = numberOfCars;
	}
	@Override
	public int compareTo(TeacherStatisticalContainer o) {
		if(this.getTotal()<o.getTotal()){
			return 1;
		}
		else if(this.getTotal()>o.getTotal()){
			return -1;
		
		}else{
		return 0;
		}
	}
	public long getNumberOfStudents() {
		return numberOfStudents;
	}
	public void setNumberOfStudents(long numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}


}
