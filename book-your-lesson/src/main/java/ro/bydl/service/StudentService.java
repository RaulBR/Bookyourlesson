package ro.bydl.service;

import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.StudentDAO;
import ro.bydl.domain.Student;
import ro.bydl.exceptions.ValidationException;

@Service
public class StudentService extends PersonHelper {

	@Autowired
	private StudentDAO dao;


	public void addStudent(Student student) throws ValidationException {
		
		refinePerson(student);
		System.out.println(student.getId());
		if (student.getId() == 0) {
			
			setRegistrationDate(student);
			validateUser(student);
			student.setStudentId(dao.insert(student));
			student.setPermision("student");
			addUser(student);

		} else {
			
			student.setRegistrationDate(dao.findById(student.getId()).getRegistrationDate());
			student.setCnp(student.getCnp());
			dao.update(student);
			
		}
		
		
		

	}

	@SuppressWarnings("unused")
	private void validateStudent(Student student) throws ValidationException {
		List<String> errors = new LinkedList<String>();

		if (!isCnpCorectFormat(student)) {
			errors.add("cnp incorect format");
		}
		if (!isCnpRightLength(student)) {
			errors.add("cnp of an incorect length");
		}
		if (cnpExists(student)) {
			errors.add("data already exists");
		}if(find(student.getEmail())>0){
			errors.add("email exists");
		}
		
		if (isEmailUsed(student)) {
			errors.add("email already exists");

		}
		if(isEmpty(student)){
			errors.add("complete necesar fields");
		}

		if (!errors.isEmpty()) {
			throw new ValidationException(errors.toArray(new String[] {}));
		}
		

	}

	

	private long find(String email) {
		if(email.equals("")){
			return 0;
		}else{
		return dao.find(email);
		}
	}

	private boolean isEmailUsed(Student student) {
		try {

			dao.getByEmail(student.getEmail());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	private boolean cnpExists(Student student) {
		if(student.getCnp().isEmpty()){
			return false;
		}
		try {
			String cnp = student.getCnp();
			dao.getByCnp(cnp);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	private Student setRegistrationDate(Student student) {

		Calendar cal = Calendar.getInstance();

		student.setRegistrationDate((cal.getTime()));
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

	public void delete(Student student) {
		dao.delete(student);
		
	}



}
