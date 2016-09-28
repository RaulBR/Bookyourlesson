package ro.bydl.dao.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ro.bydl.dao.TeacherDAO;
import ro.bydl.domain.Teacher;;
@Component
public class JdbcTeamplateTeacherDAO implements TeacherDAO{
	@Autowired
	JdbcTemplate jdbcTeamplate;

	
	

	private static class TeacherMapper implements RowMapper<Teacher> {

		@Override
		public Teacher mapRow(ResultSet rs, int arg1) throws SQLException {
			Teacher teacher = new Teacher();
			teacher.setId(rs.getInt("id"));
			teacher.setName(rs.getString("name"));
			teacher.setSirName(rs.getString("sir_name"));
			teacher.setCnp(rs.getLong("cnp"));
			teacher.setCategory(rs.getString("category"));
			teacher.setEmail(rs.getString("email"));
			teacher.setPhoneNumber(rs.getLong("phone"));
			teacher.setMedDate(rs.getString("med_date"));
			teacher.setBirthDay(rs.getString("birth_day"));
			teacher.setHireDate(rs.getString("hire_date"));
			
			
			return teacher;
		}
	}




	@Override
	public Collection<Teacher> getAll() {
		
			return jdbcTeamplate.query("SELECT name, sir_name, cnp, hire_date, category, phone, email, med_date, "+
       "birth_day, id "+
			       "FROM public.teachers;",new TeacherMapper()) ;
	}




	@Override
	public Teacher findById(Long id) {
		
		return  jdbcTeamplate.queryForObject("SELECT name, sir_name, cnp, hire_date, category, phone, email, med_date, "+
      "birth_day,id "+

			       "FROM public.teachers  WHERE id=? ;",new Long [] {id}, new TeacherMapper()) ;
		
	 
	}




	@Override
	public Teacher update(Teacher teacher) {
		
		return jdbcTeamplate.queryForObject("INSERT INTO public.teachers( name, sir_name, cnp, "
				+ "hire_date, category, phone, email, med_date, "+
            "birth_day) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id",new Object[] { 
		   teacher.getName(), teacher.getSirName(), teacher.getCnp(), teacher.getHireDate(),
					 teacher.getCategory(),teacher.getPhoneNumber(),
					teacher.getEmail(),teacher.getMedDate(),teacher.getBirthDay() },new IDtMapper());
	}




	@Override
	public int delete(Teacher model) {
		
		return jdbcTeamplate.update("DELETE FROM public.teachers "+
		 "WHERE id=?;",model.getId());

	}




	@Override
	public int edit(Teacher model) {
		// TODO Auto-generated method stub
		return 0;
	}




	@Override
	public Collection<Teacher> getByTeacher(int theacherId) {
		
		return null;
	}
	private static class IDtMapper implements RowMapper<Teacher> {

		@Override
		public Teacher mapRow(ResultSet rs, int arg1) throws SQLException {
			Teacher student = new Teacher();
			student.setId(rs.getLong("id"));
			return student;
		}
	}
}
