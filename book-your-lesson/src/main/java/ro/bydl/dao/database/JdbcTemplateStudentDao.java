package ro.bydl.dao.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.bydl.dao.PersonDAO;
import ro.bydl.domain.Student;
;

public class JdbcTemplateStudent implements PersonDAO {
	private JdbcTemplate jdbcTemplate;

	@Override
	public Collection<Student> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT id, name, sir_name, cnp, register_date, category, teacher_id "+
				 "FROM public.students;", new StudentMapper() );
	}

	@Override
	public Student findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Student model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Student model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edit(Student model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<Student> getByTeacher(int theacherId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static class StudentMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet rs, int arg1) throws SQLException {
			Student student = new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setSirName(rs.getString("sir_name"));
			student.setCnp(rs.getLong("cnp"));
			student.setRegistrationDate(rs.getString("registration_date"));
			student.setPsihoTest(rs.getBoolean("pshiho_test"));
			student.setMedPaper(rs.getBoolean("med_paper"));
			student.setRecord(rs.getBoolean("record"));
			student.setTeacherId(rs.getInt("teacher_id"));
			student.setCategory(rs.getString("category"));
			return student;
		}
	}

}
