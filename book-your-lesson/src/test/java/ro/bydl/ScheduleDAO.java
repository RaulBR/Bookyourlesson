package ro.bydl;

import java.util.Collection;

import ro.bydl.dao.BaseDao;
import ro.bydl.domain.Schedule;

/**
 * This interface gives the specific DB method for Schedules
 * 
 * @author Raul
 *
 */
public interface ScheduleDAO extends BaseDao<Schedule> {

	Collection<Schedule> searchByStudentId(long id, long teacherId);

	Collection<Schedule> searchByWeek(int week);

	Collection<Schedule> searchSchedules(int startHour, int endHour, String date);

	Collection<Schedule> searchByStudentId(long id);

	Collection<Schedule> searchByTeacherId(long id);

	long coutStudentStatus(String string, Long long1);

	long coutTeacherStatus(String string, Long long1);

}
