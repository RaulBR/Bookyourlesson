package ro.bydl.dao;

import java.util.Collection;

import ro.bydl.domain.Schedule;

public interface ScheduleDao extends BaseDao<Schedule>  {
	
	Collection<Schedule> searchByWeek(int week);
	
	Collection<Schedule> searchSchedules(int startHour,int endHour,String date);
	
	Collection<Schedule> searchStudentsSchedules(Schedule schedule, int s);
	
	Collection<Schedule> searchTeachersSchedules(Schedule schedule);
}
