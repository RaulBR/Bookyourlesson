package ro.bydl.service;

import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.TeacherDAO;
import ro.bydl.domain.Teacher;
import ro.bydl.exceptions.ValidationException;

@Service

public class TeacherService extends PersonHelper {

	@Autowired
	private TeacherDAO dao;

	public Teacher findById(long id) {

		return dao.findById(id);
	}

	public void addTeacher(Teacher teacher) throws ValidationException {

		
		refinePerson(teacher);
		setHireDate(teacher);
		validateTeacher(teacher);
		validateUser(teacher);
		teacher.setTeacherId(dao.insert(teacher));
		teacher.setPermision("teacher");
		addUser(teacher);
		
	}

	private void setHireDate(Teacher teacher) {
		Calendar cal = Calendar.getInstance();

		teacher.setHireDate((cal.getTime()));
	}

	public Collection<Teacher> getAll() {

		return dao.getAll();
	}

	private void validateTeacher(Teacher teacher) throws ValidationException {
		List<String> errors = new LinkedList<String>();

		if (!isCnpCorectFormat(teacher)) {
			errors.add("cnp incorect format");
		}if (!isCnpRightLength(teacher)) {
			errors.add("cnp of an incorect length");
		}
		if (dao.find(teacher.getEmail()) > 0) {
			errors.add(" email is used");
		}
		
		if (cnpExists(teacher)) {
			errors.add("data already exists");
		}
		if (isEmailUsed(teacher)) {
			errors.add("email already exists");

		}
		if (isEmpty(teacher)) {
			errors.add("don't leame empty field");
		}

		if (!errors.isEmpty()) {
			throw new ValidationException(errors.toArray(new String[] {}));
		}
		
	}

	private boolean isEmailUsed(Teacher teacher) {
		try {
			dao.findByEmail(teacher.getEmail());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean cnpExists(Teacher teacher) {
		try {
			dao.findByCnp(teacher.getCnp());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void delete(Teacher teacher) {
		dao.delete(teacher);
		
	}

	public Collection<Teacher> findContaining(String value) {
		
		return null;
	}

}
