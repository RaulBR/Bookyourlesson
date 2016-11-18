package ro.bydl.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.ScheduleDAO;
import ro.bydl.domain.Schedule;
import ro.bydl.exceptions.ValidationException;

/**
 * Service class for schedules
 * 
 * @author Raul
 *
 */
@Service
public class ScheduleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleService.class);

	@Autowired

	ScheduleDAO dao;

	/**
	 * Returners an arrey of strings format type dd.MM.yyyy
	 * 
	 * @param week
	 * @return String[] week days
	 */
	public String[] getDays(int week) {
		CalendarHelper calHelp = new CalendarHelper();
		return calHelp.getDays(week);
	}

	/**
	 * validation method for type schedule (empty)
	 * 
	 * @param schedule
	 * @throws ValidationException
	 */
	public void validate(Schedule schedule) throws ValidationException {

	}

	/**
	 * method gets all schedules form the DB.
	 * 
	 * @return Collection<Schedule>
	 */
	public Collection<Schedule> getScheduels() {

		return dao.getAll();
	}

	/**
	 * Method adds schedules to the Db
	 * 
	 * @param schedule
	 */
	public void save(Schedule schedule) {

		LOGGER.debug("Saving: " + schedule);
		dao.insert(schedule);

	}

	/**
	 * Method delletss schedules to the Db
	 * 
	 * @param schedule
	 */
	public void delete(Schedule schedule) {
		LOGGER.debug("Deleting: " + schedule);
		dao.delete(schedule);

	}

	/**
	 * Method returns number of schedules form db.
	 * 
	 * @param id
	 * @return int
	 */
	public int countSchedules(long id) {

		return (dao.searchByStudentId(id).size() * 100 / 30);

	}

	/**
	 * method updates schedule
	 * 
	 * @param schedule
	 */
	public void update(Schedule schedule) {

		dao.update(schedule);

	}

	/**
	 * returnes schedules based on theacher id
	 * 
	 * @param teahcerId
	 * @return Collection<Schedule>
	 */
	public Collection<Schedule> searchByTeacherId(long teahcerId) {

		return dao.searchByTeacherId(teahcerId);
	}
/**
 * returns scheduled based on student id
 * @param id
 * @return Collection<Schedule>
 */
	public Collection<Schedule> searchByStudentId(int id) {

		return dao.searchByStudentId(id);
	}

	public int pending(long id) {
		int nr = 0;
		for (Schedule s : dao.searchByStudentId(id)) {
			if (s.getStatus().equals("pending") || s.getStatus().equals("booked")) {
				nr++;
			}

		}
		return (nr * 100 / 15);
	}

	public int absent(long id) {
		int nr = 0;
		for (Schedule s : dao.searchByStudentId(id)) {
			if (s.getStatus().equals("absent")) {
				nr++;
			}

		}
		return (nr * 100 / 10);
	}

	public int done(long id) {
		int nr = 0;
		for (Schedule s : dao.searchByStudentId(id)) {
			if (s.getStatus().equals("done")) {
				nr++;
			}

		}
		return (nr * 100 / 30);
	}

	public Collection<Schedule> searchByStudentId(long l, long teacherId) {

		return dao.searchByStudentId(l, teacherId);
	}

}
