package ro.bydl.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.StudentDAO;
import ro.bydl.domain.Student;
import ro.bydl.service.errors.ValidationException;

@Service
public class StudentService extends PersonHelper {

	@Autowired
	private StudentDAO dao;

	public long addStudent(Student student) throws ValidationException {
		student.setBirthDay(birthDay(student.getCnp()));
		validateStudent(setRegistrationDate(student));

		return dao.insert(student);

	}

	private void validateStudent(Student student) throws ValidationException {
		List<String> errors = new LinkedList<String>();

		if (!isAllawed(student)) {
			errors.add("you are to yong  :)");
		}
		if (!isCnpRightLength(student)) {
			errors.add("cnp of an incorect length");
		}
		if (!cnpExists(student)) {
			errors.add("data already exists");
		}
		if (isInTheFuture(student)) {
			errors.add("you may be form the future /n go back in time to register");
		}
				
		if (!errors.isEmpty()) {
			throw new ValidationException(errors.toArray(new String[] {}));
		}

	}

	

	private boolean isInTheFuture(Student student) {
		student.getBirthDay();

		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		// TODO
		Date date;
		Date registerDate;
		try {
			date = format.parse((student.getBirthDay()));
			registerDate = format.parse((student.getRegistrationDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// if(registerDate<date){
		// return true;
		// }

		return false;
	}

	private boolean cnpExists(Student student) {
		try {
			String cnp = student.getCnp();
			dao.getByCnp(cnp);
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	private Student setRegistrationDate(Student student) {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();

		student.setRegistrationDate(dateFormat.format(cal.getTime()));
		return student;
	}

	public Collection<Student> getAll() {

		return dao.getAll();

	}

	public Collection<Student> getByTeacherId(long id) {

		return dao.getByTeacher(id);

	}

	public Student findById(long id) {
		return dao.findById(id);

	}

	public boolean isCnpRightLength(Student student) {
		String cnp = student.getCnp();
		if (cnp.length() < 12) {
			return false;
		} else {
			return true;
		}

	}

}
