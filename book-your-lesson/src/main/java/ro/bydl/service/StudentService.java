package ro.bydl.service;

import java.util.Calendar;
import java.util.Collection;
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
		refinePerson(student);
		setRegistrationDate(student);
		validateStudent(setRegistrationDate(student));
		return dao.insert(student);

	}

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
		}
		// if (isInTheFuture(student)) {
		// errors.add("you may be form the future /n go back in time to
		// register");
		// }
		if (isEmailUsed(student)) {
			errors.add("email already exists");

		}

		if (!errors.isEmpty()) {
			throw new ValidationException(errors.toArray(new String[] {}));
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

	public boolean isCnpRightLength(Student student) {
		String cnp = student.getCnp();
		if (cnp.length() < 12) {
			return false;
		} else {
			return true;
		}

	}

}
