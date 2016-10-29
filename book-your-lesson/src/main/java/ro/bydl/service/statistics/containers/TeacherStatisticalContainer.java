package ro.bydl.service.statistics.containers;

import ro.bydl.domain.Teacher;

public class TeacherStatisticalContainer extends PersonStatisticContainer<Teacher>  
implements Comparable<TeacherStatisticalContainer>{
	
	
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


}
