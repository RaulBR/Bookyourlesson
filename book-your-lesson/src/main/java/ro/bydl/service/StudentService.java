package ro.bydl.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.database.JdbcTemplateStudentDAO;
import ro.bydl.domain.Student;

@Service
public class StudentService extends PersonService{
@Autowired
JdbcTemplateStudentDAO dao;

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

	public boolean isCnpRightLength(Student student) {
		String cnp=Long.toString(student.getCnp());
		if(cnp.length()<12){
		return false;
	}else{
		return true;
	}
	
	}
	
	
	
}
