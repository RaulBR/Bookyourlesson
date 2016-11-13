package ro.bydl.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.ScheduleDAO;
import ro.bydl.domain.Schedule;
import ro.bydl.service.errors.ValidationException;

@Service
public class ScheduleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleService.class);

	@Autowired

	ScheduleDAO dao;

	public String[] getDays(int week) {
		CalendarHelper calHelp = new CalendarHelper();
		return calHelp.getDays(week);
	}

	public void validate(Schedule schedule) throws ValidationException {

		
//	List errors= new LinkedList<>();
//	if(isScheduleInThePast(schedule)){
//		
//		errors.add("you canot book lessons in the past :)");
//	}

		
	}

//	private boolean isScheduleInThePast(Schedule schedule) {
//	Date date=new Date();
//	
//			return false;
//	}

	public Collection<Schedule> getScheduels() {

		return dao.getAll();
	}

	public void save(Schedule schedule) {

		LOGGER.debug("Saving: " + schedule);
		dao.insert(schedule);

	}

	public void delete(Schedule schedule) {
		LOGGER.debug("Deleting: " + schedule);
		dao.delete(schedule);

	}

	public int countSchedules(long id) {

		return (dao.searchByStudentId(id).size() * 100 / 30);

	}

	public long update(Schedule schedule) {

		return (dao.update(schedule));

	}

	public Collection<Schedule> searchByTeacherId(long teahcerId) {

		return dao.searchByTeacherId(teahcerId);
	}

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
