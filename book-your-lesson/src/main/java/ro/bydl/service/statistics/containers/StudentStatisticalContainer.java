package ro.bydl.service.statistics.containers;

import ro.bydl.domain.Student;

public class StudentStatisticalContainer extends PersonStatisticContainer<Student> implements Comparable<StudentStatisticalContainer>{
	@Override
	public int compareTo(StudentStatisticalContainer o) {
		if(this.getTotal()<o.getTotal()){
			return 1;
		}
		else if(this.getTotal()>o.getTotal()){
			return -1;
		
		}else{
		return 0;
		}
	}
}
