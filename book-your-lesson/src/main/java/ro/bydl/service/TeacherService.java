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

/**
 * Servis class for teacher handeling
 * 
 * @author Raul
 *
 */
@Service

public class TeacherService extends PersonHelper {

	@Autowired
	private TeacherDAO dao;

	/**
	 * this method finds a teacher by id
	 * 
	 * @param id
	 * @return Teacher
	 */
	public Teacher findById(long id) {

		return dao.findById(id);
	}

	/**
	 * this method adds a teacher to the DB based via validation. *
	 * <p>
	 * Validates:
	 * </p>
	 * <ul>
	 * <li>if fields are empty</li>
	 * <li>if cnp is of correct length</li>
	 * <li>if email is used</li>
	 * <li>if user is used</li>
	 * <li>if passwords match</li>
	 * </ul>
	 * 
	 * @param teacher
	 * @throws ValidationException
	 */
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
		}
		if (!isCnpRightLength(teacher)) {
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

	/**
	 * this method deletes a teacher form the Db based on Id
	 * 
	 * @param teacher
	 */
	public void delete(Teacher teacher) {
		dao.delete(teacher);

	}

}
