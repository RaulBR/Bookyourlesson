package ro.bydl.dao.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ro.bydl.dao.ScheduleDao;
import ro.bydl.domain.Schedule;
import ro.bydl.domain.Status;

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

		return jdbcTemplate.update(
				"INSERT INTO public.schedule(" + " week, start_hour, end_hour, date, student_id, teacher_id, "
						+ " status) " + "VALUES ( ?, ?, ?, ?, ?, ?, ?);",
				schedule.getWeek(), schedule.getStartHour(), schedule.getEndHour(), schedule.getDate(), 1, 1,
				schedule.getStatus());
	}

	@Override
	public int delete(Schedule schedule) {

		return jdbcTemplate.update("DELETE FROM public.schedule " + "WHERE id=?", schedule.getId());
	}

	@Override
	public Collection<Schedule> searchSchedules(int startHour, int endHour, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Schedule> searchStudentsSchedules(Schedule schedule, int studentID) {
		return jdbcTemplate.query("select FROM schedule where week=?, student_id=?",
				new Object[] { schedule.getWeek(), studentID },

				new ScheduleMapper());
	}

	@Override
	public Collection<Schedule> getAll() {

		return jdbcTemplate.query("SELECT week, start_hour, end_hour, date, id, student_id, teacher_id, " + "status "
				+ "FROM public.schedule;", new ScheduleMapper());
	}

	@Override
	public Collection<Schedule> searchByWeek(int week) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select FROM schedule where week=?", new Integer[] { week }, new ScheduleMapper());
	}

	@Override
	public int edit(Schedule schedule) {
System.out.println(schedule.getStudentId());
		return jdbcTemplate
				.update("UPDATE public.schedule " + "  SET week=?, start_hour=?, end_hour=?, date=?,  student_id=?, "
						+ " teacher_id=?, status=? " + "WHERE id=?;", schedule.getWeek(), schedule.getStartHour(), schedule.getEndHour(), 
																	schedule.getDate(), schedule.getStudentId(), schedule.getTeacherId(),
																			schedule.getStatus(),schedule.getId());
	}

	@Override
	public Collection<Schedule> searchTeachersSchedules(Schedule schedule) {
		// TODO Auto-generated method stub
		return null;
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
			schedule.setStudentId(rs.getInt("student_id"));
			schedule.setTeacherId(rs.getInt("teacher_id"));
			schedule.setStatus(rs.getString("status"));

			return schedule;
		}

	}

}
