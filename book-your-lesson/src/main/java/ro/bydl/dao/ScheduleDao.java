package ro.bydl.dao;

import java.util.Collection;

import ro.bydl.domain.Schedule;

public interface ScheduleDao extends BaseDao<Schedule>  {
	
	Collection<Schedule> searchByWeek(int week);
	
	Collection<Schedule> searchSchedules(int startHour,int endHour,String date);
	
	Collection<Schedule> searchStudentsSchedules(int week, int studentID);
	
	Collection<Schedule> searchTeachersSchedules(int week, int teacherID);
}
