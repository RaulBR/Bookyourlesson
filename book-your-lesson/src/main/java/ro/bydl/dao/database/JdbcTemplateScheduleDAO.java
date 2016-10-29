package ro.bydl.dao.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ro.bydl.dao.ScheduleDAO;
import ro.bydl.domain.Schedule;

@Component
public class JdbcTemplateScheduleDAO implements ScheduleDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Schedule findById(long id) {
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

	@Override
	public Collection<Schedule> searchByTeacherId(long id) {

		return jdbcTemplate.query("SELECT week, start_hour, end_hour, date, id, student_id, teacher_id, " + "status "
				+ "FROM public.schedule WHERE teacher_id=?;", new Long[] { id }, new ScheduleMapper());
	}

	@Override
	public Collection<Schedule> searchByStudentId(long id) {

		return jdbcTemplate.query("SELECT week, start_hour, end_hour, date, id, student_id, teacher_id, " + "status "
				+ "FROM public.schedule WHERE student_id=?;", new Long[] { id }, new ScheduleMapper());
	}

	@Override
	public int delete(Schedule schedule) {
		return jdbcTemplate.update("DELETE FROM public.schedule " + "WHERE id=?", schedule.getId());
	}

	@Override
	public Collection<Schedule> searchSchedules(int startHour, int endHour, String date) {
		return null;
	}

	@Override
	public Collection<Schedule> getAll() {

		return jdbcTemplate.query("SELECT week, start_hour, end_hour, date, id, student_id, teacher_id, " + "status "
				+ "FROM public.schedule;", new ScheduleMapper());
	}

	@Override
	public Collection<Schedule> searchByWeek(int week) {
		return jdbcTemplate.query("SELECT week, start_hour, end_hour, date, id, student_id, teacher_id, status "
				+ "FROM public.schedule WHERE week=?", new Integer[] { week }, new ScheduleMapper());
	}

	@Override
	public int edit(Schedule schedule) {

		return jdbcTemplate.update(
				"UPDATE public.schedule " + "  SET week=?, start_hour=?, end_hour=?, date=?,  student_id=?, "
						+ " teacher_id=?, status=? " + "WHERE id=?;",
				schedule.getWeek(), schedule.getStartHour(), schedule.getEndHour(), schedule.getDate(),
				schedule.getStudentId(), schedule.getTeacherId(), schedule.getStatus(), schedule.getId());
	}

	@Override
	public Collection<Schedule> searchByStudentId(long id, long teacherId) {

		return jdbcTemplate.query(
				"SELECT week, start_hour, end_hour, date, id, student_id, teacher_id, " + "status "
						+ "FROM public.schedule WHERE student_id=? OR teacher_id = ?;",
				new Long[] { id, teacherId }, new ScheduleMapper());
	}

	@Override
	public Collection<Schedule> selectDistinctTeacherId() {
		return jdbcTemplate.query("SELECT DISTINCT teacher_id" + "FROM public.schedule;", new ScheduleMapper());

	}

	public Integer countScheedules(long teacherId) {

		return jdbcTemplate.queryForObject("SELECT  count(*)  teacher_id FROM public.schedule  WHERE teacher_id=?; ",
				new Long[] { teacherId }, Integer.class);
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
	@Override
	public long coutTeacherStatus(int week, String status, long techerId) {

		return jdbcTemplate.queryForObject(
				"SELECT count(*)  id  FROM public.schedule WHERE week=? AND status=? AND  schedule.teacher_id=?;",
				new Object[] { week, status, techerId }, Long.class);
	}
	@Override
	public long coutTeacherStatus(String status, long techerId) {

		return jdbcTemplate.queryForObject(
				"SELECT count(*) " + "id " + "FROM public.schedule WHERE status=? AND schedule.teacher_id=?;",
				new Object[] { status, techerId }, Long.class);
	}
	@Override
	public long coutStudentStatus(int week, String status, long studentId) {

		return jdbcTemplate.queryForObject(
				"SELECT count(*)  id  FROM public.schedule WHERE week=? AND status=? AND  schedule.student_id=?;",
				new Object[] { week, status, studentId }, Long.class);
	}
	@Override
	public long coutStudentStatus(String status, long studentId) {

		return jdbcTemplate.queryForObject(
				"SELECT count(*) " + "id " + "FROM public.schedule WHERE status=? AND schedule.student_id=?;",
				new Object[] { status, studentId }, Long.class);
	}

	

}
