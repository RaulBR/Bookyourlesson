package ro.bydl;

import java.util.Collection;

import ro.bydl.domain.Schedule;
/**
 * This interface gives the specific DB method for Schedules
 * @author Raul
 *
 */
public interface ScheduleDAO<T>  {
Collection<T> getAll();
	
	T findById(Long id);
	
	T update(T model);
	
	boolean delete(T model);

	int edit(T model);

	Collection<Schedule> searchByWeek(int week);

	Collection<Schedule> searchSchedules(int startHour, int endHour, String date);

	Collection<Schedule> searchByStudentId(long id);

	Collection<Schedule> searchByTeacherId(long id);

	Schedule update(Schedule model);

	int edit(Schedule model);

}
