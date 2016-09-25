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
public class jdbcTemplateUserDao implements UserDAO{
	
@Autowired	
JdbcTemplate jdbcTeamplate;

	@Override
	public Collection<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		 jdbcTeamplate.update("INSERT INTO public.users( "+
			        " users, pass, permision, student_id, teacher_id) "+
					    "VALUES ( ?, ?, ?, ?, ?);", user.getUser(),
					    user.getPass(),
					    user.getPermision(),
					    user.getStudentId(),
					    user.getTeacherId() ); 
		return user;
	}

	@Override
	public int delete(User model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edit(User model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<User> getAllUsers() {
		// TODO Auto-generated method stub
		return jdbcTeamplate.query("SELECT users, pass, permision, student_id, teacher_id, id  FROM public.users; ",
				new UserMapper());
	}

	private static class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user=new User();
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
