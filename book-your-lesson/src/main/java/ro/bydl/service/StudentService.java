package ro.bydl.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.database.JdbcTemplateStudentDao;
import ro.bydl.domain.Student;
import ro.bydl.domain.Teacher;

@Service
public class StudentService extends PersonService{
@Autowired
JdbcTemplateStudentDao dao;

	public Student addStudent(Student student){
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		
		student.setRegistrationDate(dateFormat.format(cal.getTime()));
				return dao.update(student);
		
		
	}
	
	public Collection<Student> getAll(){

				return dao.getAll();
		
		
	}
	
	public Collection<Student> getByTeacherId(long id){

		return dao.getByTeacher( id);


}

	public Student findById(long id) {
		return dao.findById(id);
		
		
	}
	

}
