package ro.bydl.dao.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ro.bydl.dao.ScheduleDao;
import ro.bydl.domain.Schedule;


public class JdbcTemplateScheduleeDao implements ScheduleDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	

	
	@Override
	public Schedule findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Schedule schedule) {
		
		return  jdbcTemplate.update("INSERT INTO public.schedule(week, start_hour, end_hour, date, stundent_name, teacher_name)"+ 
           
   " VALUES (?, ?, ?, ?, ?, ?)",
            schedule.getWeek(),schedule.getStartHour(),schedule.getEndHour(), schedule.getDate(),"uuu","vasi");
	}

	@Override
	public int delete(Schedule schedule) {
		
		return  jdbcTemplate.update("DELETE FROM public.schedule "+
 "WHERE id=?", 
		          schedule.getId());
	}

	
	@Override
	public Collection<Schedule> searchSchedules(int startHour, int endHour, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Schedule> searchStudentsSchedules(int week,int studentID) {
		 return jdbcTemplate.query("select FROM schedule where week=?, student_id=?" ,
				 new Object[] {week, studentID},
				
				new ScheduleMapper());
	}

	@Override
	public Collection<Schedule> searchTeachersSchedules(int week, int teacherID) {
		
		  return jdbcTemplate.query("select FROM schedule where week=?, teacher_id=?" ,
				 new Integer[] {week, teacherID},
				
				new ScheduleMapper());
	}

	@Override
	public Collection<Schedule> getAll() {
	
		 return jdbcTemplate.query("SELECT week, start_hour, end_hour, date, stundent_name, teacher_name, "+
			       "id "+
			       "FROM public.schedule;" ,
								new ScheduleMapper());
	}

	@Override
	public Collection<Schedule> searchByWeek(int week) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select FROM schedule where week=?",
				new Integer[] {week},
				new ScheduleMapper());
	}
	private static class ScheduleMapper implements RowMapper<Schedule> {
		
		@Override
		public Schedule mapRow(ResultSet rs, int arg1) throws SQLException {
			Schedule schedule = new Schedule();
			schedule.setId(rs.getInt("id"));
			schedule.setDate(rs.getString("date"));
			schedule.setWeek(rs.getInt("week"));
			schedule.setStartHour(rs.getInt("start_hour"));
			schedule.setEndHour(rs.getInt("end_hour"));
			schedule.setStudentName(rs.getString("stundent_name"));
			schedule.setTeacherName(rs.getString("teacher_name"));
			schedule.setStatus(rs.getString("status"));
					
			return schedule;
		}

	}
	@Override
	public int edit(Schedule model) {
		// TODO Auto-generated method stub
		return 0;
	}

}
