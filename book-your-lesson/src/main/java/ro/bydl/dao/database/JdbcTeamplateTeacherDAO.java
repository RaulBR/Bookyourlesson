package ro.bydl.dao.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ro.bydl.dao.TeacherDAO;
import ro.bydl.domain.Teacher;

@Component
public class JdbcTeamplateTeacherDAO implements TeacherDAO {
	@Autowired
	JdbcTemplate jdbcTeamplate;

	private static class TeacherMapper implements RowMapper<Teacher> {

		@Override
		public Teacher mapRow(ResultSet rs, int arg1) throws SQLException {
			Teacher teacher = new Teacher();
			teacher.setId(rs.getInt("id"));
			teacher.setName(rs.getString("name"));
			teacher.setSirName(rs.getString("sir_name"));
			teacher.setCnp(rs.getString("cnp"));
			teacher.setCategory((rs.getString("category")));
			teacher.setEmail(rs.getString("email"));
			teacher.setPhoneNumber(rs.getString("phone"));
			teacher.setMedDate(rs.getString("med_date"));
			teacher.setBirthDay(rs.getDate("birth_day"));
			teacher.setHireDate(rs.getDate("hire_date"));

			return teacher;
		}
	}

	@Override
	public Teacher findByEmail(String email) {

		return jdbcTeamplate.queryForObject(
				"SELECT name, sir_name, cnp, hire_date, category, phone, email, med_date, " + "birth_day,id " +

						"FROM public.teachers  WHERE email=? ;",
				new String[] { email }, new TeacherMapper());
	}

	@Override
	public Collection<Teacher> getAll() {

		return jdbcTeamplate.query("SELECT name, sir_name, cnp, hire_date, category, phone, email, med_date, "
				+ "birth_day, id " + "FROM public.teachers;", new TeacherMapper());
	}

	@Override
	public Teacher findById(long id) {

		return jdbcTeamplate.queryForObject(
				"SELECT name, sir_name, cnp, hire_date, category, phone, email, med_date, " + "birth_day,id " +

						"FROM public.teachers  WHERE id=? ;",
				new Long[] { id }, new TeacherMapper());

	}

	@Override
	public Teacher findByCnp(String cnp) {

		return jdbcTeamplate.queryForObject(
				"SELECT name, sir_name, cnp, hire_date, category, phone, email, med_date, " + "birth_day,id " +

						"FROM public.teachers  WHERE cnp=? ;",
				new String[] { cnp }, new TeacherMapper());
	}

	@Override
	public long insert(Teacher teacher) {

		return jdbcTeamplate.queryForObject(
				"INSERT INTO public.teachers("
						+ "name, sir_name, category, email, med_date, cnp, phone, birth_day, hire_date)"
						+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id ;",
				new Object[] { teacher.getName(), teacher.getSirName(), teacher.getCategory(), teacher.getEmail(),
						teacher.getMedDate(), teacher.getCnp(), teacher.getPhoneNumber(), teacher.getBirthDay(),
						teacher.getHireDate() },
				Long.class);
	}

	@Override
	public int delete(Teacher model) {

		return jdbcTeamplate.update("DELETE FROM public.teachers " + "WHERE id=?;", model.getId());

	}

	@Override
	public void update(Teacher m) {
		jdbcTeamplate.update(
				"UPDATE public.teachers  SET name=?, sir_name=?, category=?, email=?, med_date=?, cnp=?, "
						+ " phone=?, birth_day=?, hire_date=? WHERE id=?;",
				m.getName(), m.getSirName(), m.getCategory(), m.getEmail(), m.getMedDate(), m.getCnp(),
				m.getPhoneNumber(), m.getBirthDay(), m.getHireDate());

	}

	@Override
	public long find(String email) {

		return jdbcTeamplate.queryForObject("SELECT count(*) " + "FROM public.teachers WHERE email=? ;",
				new String[] { email }, Long.class);
	}

	@Override
	public Collection<Teacher> findByIncompletName(String value) {
		// TODO Auto-generated method stub
		return jdbcTeamplate.query(
				"SELECT name, sir_name, category, email, med_date, id, cnp, phone, birth_day, hire_date "+
    " FROM public.teachers   WHERE name LIKE ? OR sir_name LIKE ?;",
				new String[] {"%"+ value +"%", "%"+ value +"%"}, new TeacherMapper()); 
	}

}
