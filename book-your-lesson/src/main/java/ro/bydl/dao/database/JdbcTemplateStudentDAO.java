package ro.bydl.dao.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ro.bydl.dao.StudentDAO;
import ro.bydl.domain.Category;
import ro.bydl.domain.Student;

@Component
public class JdbcTemplateStudentDAO implements StudentDAO {

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
	public long insert(Student student) {
		

		return jdbcTemplate.queryForObject(
				"INSERT INTO public.students(name, sir_name, cnp, register_date, category, teacher_id, " +
				"med_paper, phone, email, birth_day) "+
    "VALUES ( ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?) RETURNING id;",
				new Object[] { student.getName(), student.getSirName(), student.getCnp(), student.getRegistrationDate(),
						student.getCategory(), student.getTeacherId(), student.isMedPaper(), student.getPhoneNumber(),
						student.getEmail(),student.getBirthDay() },
				Long.class);
	}

	@Override
	public int delete(Student model) {
		
		return jdbcTemplate.update("DELETE FROM public.students "+
				 "WHERE id=?;",model.getId());
	}

	@Override
	public void update(Student student) {
		
		jdbcTemplate.update("UPDATE public.students  SET name=?, sir_name=?, cnp=?, register_date=?, category=?, "+
       "teacher_id=?, med_paper=?, phone=?, email=?, birth_day=? WHERE id=?;",
     student.getName(), student.getSirName(), student.getCnp(), student.getRegistrationDate(),
		student.getCategory(), student.getTeacherId(), student.isMedPaper(), student.getPhoneNumber(),
		student.getEmail(),student.getBirthDay(),  student.getId() );
	}

	@Override
	public Collection<Student> getByTeacher(long id) {
	
		return jdbcTemplate.query("SELECT id, name, sir_name, cnp, register_date, category, teacher_id,  med_paper, phone, email, birth_day "+ 
  "FROM public.students where teacher_id=? ;", new Long[] {id}, new StudentMapper());
	}
	@Override
	public Student getByCnp(String cnp) {
		return jdbcTemplate.queryForObject("SELECT id, name, sir_name, cnp, register_date, category, teacher_id,  med_paper, phone, email, birth_day "+ 
				  "FROM public.students where cnp=? ;", new String[] {cnp}, new StudentMapper());
		
	}
	@Override
	public Student getByEmail(String email) {
		return jdbcTemplate.queryForObject("SELECT id, name, sir_name, cnp, register_date, category, teacher_id,  med_paper, phone, email, birth_day "+ 
				  "FROM public.students where email=? ;", new String[] {email}, new StudentMapper());
		
	}

	private static class StudentMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet rs, int arg1) throws SQLException {
			Student student = new Student();
			student.setId(rs.getLong("id"));
			student.setName(rs.getString("name"));
			student.setSirName(rs.getString("sir_name"));
			student.setCnp(rs.getString("cnp"));
			student.setRegistrationDate(rs.getDate("register_date"));
			student.setMedPaper(rs.getBoolean("med_paper"));
			student.setTeacherId(rs.getInt("teacher_id"));
			student.setCategory(Category.valueOf(rs.getString("category")));
			student.setEmail(rs.getString("email"));
			student.setPhoneNumber(rs.getString("phone"));
			student.setBirthDay(rs.getDate("birth_day"));
			return student;
		}

	}

	@Override
	public long find(String email) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(
				"SELECT count(*) "+
						"FROM public.students WHERE email=? ;",new String[] {email},  Long.class);
	}

	@Override
	public long countByteacherId(long teacherId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(
				"SELECT count(*) "+
						"FROM public.students WHERE teacher_id=? ;",new Long[] {teacherId},  Long.class);
	}
	
	
	

	
}
