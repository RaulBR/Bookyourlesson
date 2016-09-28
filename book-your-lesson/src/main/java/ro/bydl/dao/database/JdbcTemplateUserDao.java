package ro.bydl.dao.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ro.bydl.dao.UserDAO;
import ro.bydl.domain.User;

@Component
public class JdbcTemplateUserDao implements UserDAO {

	@Autowired
	JdbcTemplate jdbcTeamplate;

	@Override
	public Collection<User> getAll() {

		return jdbcTeamplate.query("SELECT users, pass, permision, student_id, teacher_id, id  FROM public.users; ",
				new UserMapper());
	}

	@Override
	public User findById(Long id) {

		return jdbcTeamplate.queryForObject(
				"SELECT users, pass, permision, student_id, teacher_id, id  FROM public.users; WHERE id=?",
				new Long[] { id }, new UserMapper());
	}

	@Override
	public User update(User user) {

		jdbcTeamplate.update(
				"INSERT INTO public.users( " + " users, pass, permision, student_id, teacher_id) "
						+ "VALUES ( ?, ?, ?, ?, ?);",
				user.getUser(), user.getPass(), user.getPermision(), user.getStudentId(), user.getTeacherId());
		return user;
	}

	@Override
	public int delete(User model) {

		return jdbcTeamplate.update("DELETE FROM public.users WHERE id=?;", new Object[] { model.getId() });
	}

	@Override
	public int edit(User model) {

		return jdbcTeamplate.update(
				"UPDATE public.users  SET users=?, pass=?, permision=?, student_id=?, teacher_id=?, id=? "
						+ "WHERE id=?;",
				new Object[] { model.getUser(), model.getPass(), model.getPermision(), model.getStudentId(),
						model.getTeacherId(), model.getId() });
	}

	private static class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUser(rs.getString("users"));
			user.setPass(rs.getString("pass"));
			user.setPermision(rs.getString("permision"));
			user.setStudentId(rs.getInt("student_id"));
			user.setTeacherId(rs.getInt("teacher_id"));
			;
			return user;
		}
	}
}
