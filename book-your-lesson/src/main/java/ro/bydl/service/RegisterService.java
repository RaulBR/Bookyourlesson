package ro.bydl.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.UserDAO;
import ro.bydl.domain.User;
import ro.bydl.service.errors.ValidationException;

@Service
public class RegisterService {

	@Autowired
	UserDAO dao;

	public boolean checkUserUnique(User user) {
		try {
			dao.getByUser(user.getUser());
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public void addUser(User user) throws ValidationException {

		validation(user);
		dao.insert(user);
	}

	private void validation(User user) throws ValidationException {
		List<String> errors = new LinkedList<String>();
		if (!isPaswoardOk(user)) {
			errors.add("passwoards dont mach");
		}
		if (!checkUserUnique(user)) {
			errors.add("user exists");
		}
		if (!errors.isEmpty()) {
			throw new ValidationException(errors.toArray(new String[] {}));
		}
	}

	private boolean isPaswoardOk(User user) {

		if (user.getPass().equals(user.getPass2())) {
			return true;
		}
		return false;

	}
}
