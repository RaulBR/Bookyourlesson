package ro.bydl.dao;

import java.util.Collection;

import ro.bydl.domain.Schedule;
/**
 * This interface gives the specific DB method for Schedules
 * @author Raul
 *
 */
public interface ScheduleDAO extends BaseDao<Schedule> {

	Collection<Schedule> searchByWeek(int week);

	Collection<Schedule> searchSchedules(int startHour, int endHour, String date);

	Collection<Schedule> searchByStudentId(long id);

	Collection<Schedule> searchByTeacherId(long id);
	
	
	

}
