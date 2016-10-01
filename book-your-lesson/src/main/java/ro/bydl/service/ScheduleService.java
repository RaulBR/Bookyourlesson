package ro.bydl.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.database.JdbcTemplateScheduleeDao;
import ro.bydl.domain.Schedule;

@Service
public class ScheduleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleServiceTest.class);
	

	@Autowired
	private JdbcTemplateScheduleeDao dao;
	
	
	
	public int validate(Schedule schedule) throws ValidationException {

		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();

		try {
			cal.setTime(df.parse(schedule.getDate()));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		if (cal.get(Calendar.YEAR) > Calendar.getInstance().get(Calendar.YEAR) + 1) {
			System.out.println("error");
		}

		return Calendar.getInstance().get(Calendar.YEAR);

	}

	public Collection<Schedule> getScheduels() {

		return dao.getAll();
	}

	public void save(Schedule schedule) {

		LOGGER.debug("Saving: " + schedule);
		dao.update(schedule);

	}

	public void delete(Schedule schedule) {
		LOGGER.debug("Deleting: " + schedule);
		dao.delete(schedule);

	}
	public int countSchedules(long id){
		
		return (dao.searchByStudentId(id).size()*100/30);
		
	}
	

	public int edit(Schedule schedule) {
		
		return (dao.edit(schedule));
		
	}

	public Collection<Schedule> searchByTeacherId(long l) {
		
		return dao.searchByTeacherId(l);
	}

	

	public Collection<Schedule>  searchByStudentId(int id) {
		
		return dao.searchByStudentId(id);
	}

	public int pending(long id){
		int nr=0;
		for (Schedule s:dao.searchByStudentId(id)){
			if(s.getStatus().equals("pending")||s.getStatus().equals("booked")){
				nr++;
			}
			
		}
		return (nr*100/15);
	}
	public int absent(long id){
		int nr=0;
		for (Schedule s:dao.searchByStudentId(id)){
			if(s.getStatus().equals("absent")){
				nr++;
			}
			
		}
		return (nr*100/10);
	}
	public int done(long id){
		int nr=0;
		for (Schedule s:dao.searchByStudentId(id)){
			if(s.getStatus().equals("done")){
				nr++;
			}
			
		}
		return (nr*100/30);
	}

	public Collection<Schedule>  searchByStudentId(long l, int teacherId) {
		
		return dao.searchByStudentId(l, teacherId);
	}

}
