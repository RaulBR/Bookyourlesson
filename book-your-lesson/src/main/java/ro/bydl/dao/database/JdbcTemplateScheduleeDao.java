package ro.bydl.dao.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ro.bydl.dao.ScheduleDAO;
import ro.bydl.domain.Schedule;
import ro.bydl.domain.Student;
import ro.bydl.domain.User;

public class JdbcTemplateScheduleeDao implements ScheduleDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Schedule findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Schedule update(Schedule schedule) {
		jdbcTemplate.update(
				"INSERT INTO public.schedule( " + "week, start_hour, end_hour, date,  student_id, teacher_id, status) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?);",
				new Object[] { schedule.getWeek(), schedule.getStartHour(), schedule.getEndHour(), schedule.getDate(),
						schedule.getStudentId(), schedule.getTeacherId(), schedule.getStatus() });

		return schedule;

	}

	public Collection<Schedule> searchByTeacherId(long id) {

		return jdbcTemplate.query(
				"SELECT week, start_hour, end_hour, date, id, student_id, teacher_id, " + "status "
						+ "FROM public.schedule WHERE teacher_id=?;",
				new Long[] { id }, new ScheduleMapper());
	}
	public Collection<Schedule> searchByStudentId(Schedule schedule) {

		return jdbcTemplate.query(
				"SELECT week, start_hour, end_hour, date, id, student_id, teacher_id, " + "status "
						+ "FROM public.schedule WHERE student_id=?;",
				new Object[] { schedule.getStudentId() }, new ScheduleMapper());
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
	public Collection<Schedule> getAll() {

		return jdbcTemplate.query("SELECT week, start_hour, end_hour, date, id, student_id, teacher_id, " + "status "
				+ "FROM public.schedule;", new ScheduleMapper());
	}

	@Override
	public Collection<Schedule> searchByWeek(int week) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT "
				+ "week, start_hour, end_hour, date, id, student_id, teacher_id, "
				+ "status  where week=?", new Integer[] { week }, new ScheduleMapper());
	}

	@Override
	public int edit(Schedule schedule) {
		System.out.println(schedule.getStudentId());
		return jdbcTemplate.update(
				"UPDATE public.schedule " + "  SET week=?, start_hour=?, end_hour=?, date=?,  student_id=?, "
						+ " teacher_id=?, status=? " + "WHERE id=?;",
				schedule.getWeek(), schedule.getStartHour(), schedule.getEndHour(), schedule.getDate(),
				schedule.getStudentId(), schedule.getTeacherId(), schedule.getStatus(), schedule.getId());
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
