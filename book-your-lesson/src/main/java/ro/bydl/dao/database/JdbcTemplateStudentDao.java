package ro.bydl.dao.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ro.bydl.dao.StudnetDAO;
import ro.bydl.domain.Student;

@Component
public class JdbcTemplateStudentDAO implements StudnetDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Collection<Student> getAll() {
		
		return jdbcTemplate
				.query("SELECT id, name, sir_name, cnp, register_date, category, teacher_id,  med_paper, phone, email, birth_day "+ 
  "FROM public.students;", new StudentMapper());
	}

	@Override
	public Student findById(long id) {
		
		return jdbcTemplate.queryForObject("SELECT id, name, sir_name, cnp, register_date, category, teacher_id, "+
       "med_paper, phone, email, birth_day  FROM public.students WHERE id=?;",new Long[] {id},new StudentMapper());
	}

	@Override
	public Student update(Student student) {
		

		return jdbcTemplate.queryForObject(
				"INSERT INTO public.students(name, sir_name, cnp, register_date, category, teacher_id, " +
				"med_paper, phone, email, birth_day) "+
    "VALUES ( ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?) RETURNING id;",
				new Object[] { student.getName(), student.getSirName(), student.getCnp(), student.getRegistrationDate(),
						student.getCategory(), student.getTeacherId(), student.isMedPaper(), student.getPhoneNumber(),
						student.getEmail(),student.getBirthDay() },
				new StudentMapper());
	}

	@Override
	public int delete(Student model) {
		
		return jdbcTemplate.update("DELETE FROM public.students "+
				 "WHERE id=?;",model.getId());
	}

	@Override
	public int edit(Student student) {
		
		return jdbcTemplate.update("UPDATE public.students  SET id=?, name=?, sir_name=?, cnp=?, register_date=?, category=?, "+
       "teacher_id=?, med_paper=?, phone=?, email=?, birth_day=? WHERE <condition>;",
       new Object[] { student.getName(), student.getSirName(), student.getCnp(), student.getRegistrationDate(),
				student.getCategory(), student.getTeacherId(), student.isMedPaper(), student.getPhoneNumber(),
				student.getEmail(),student.getBirthDay(),student.getId() },
		 Integer.class);
	}

	@Override
	public Collection<Student> getByTeacher(long id) {
	
		return jdbcTemplate.query("SELECT id, name, sir_name, cnp, register_date, category, teacher_id,  med_paper, phone, email, birth_day "+ 
  "FROM public.students where teacher_id=? ;", new Long[] {id}, new StudentMapper());
	}

	private static class StudentMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet rs, int arg1) throws SQLException {
			Student student = new Student();
			student.setId(rs.getLong("id"));
			student.setName(rs.getString("name"));
			student.setSirName(rs.getString("sir_name"));
			student.setCnp(rs.getLong("cnp"));
			student.setRegistrationDate(rs.getString("register_date"));
			student.setMedPaper(rs.getBoolean("med_paper"));
			student.setTeacherId(rs.getInt("teacher_id"));
			student.setCategory(rs.getString("category"));
			student.setEmail(rs.getString("email"));
			student.setPhoneNumber(rs.getLong("phone"));
			student.setBirthDay(("birth_day"));
			return student;
		}

	}

	
}
