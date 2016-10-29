package ro.bydl.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.database.JdbcTemplateStudentDao;
import ro.bydl.domain.Student;

@Service
public class StudentService extends PersonHelper{
	
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
	
	public boolean isAllawed(Student student ){
		DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		java.util.Date date = null;
		try {
			 date =  formatter.parse(student.getBirthDay());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(date);
		LocalDateTime now = LocalDateTime.now();
		
		if(calendar.getWeekYear()-now.getYear()<18){
			return false;
		}else{
		return true;
		
	}}
}
