package ro.bydl.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.UserDAO;
import ro.bydl.domain.User;
import ro.bydl.exceptions.ValidationException;

@Service
public class RegisternService {

	@Autowired
	private UserDAO dao;

	public boolean checkUserUnique(User user) {
		try {
			dao.getByUser(user.getUser());
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public void addUser(User user) throws ValidationException {
		
		validateUser(user);

		dao.insert(ajustUser(user));
	}

	private User ajustUser(User user) {
		PasswordHelper ps=new PasswordHelper();
	user.setPass(ps.hash(user.getPass().toCharArray()));
	user.setPass2(ps.hash(user.getPass2().toCharArray()));
		return user;
	}

	public void validateUser(User user) throws ValidationException {
		List<String> errors = new LinkedList<String>();
		if (isEmpty(user)) {
			errors.add("user and password filends can't be empty");
		}
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

	private boolean isEmpty(User user) {
		if (user.getUser().isEmpty()) {
			return true;
		}
		if (user.getPass().isEmpty()) {
			return true;
		}
		if (user.getPass2().isEmpty()) {
			return true;
		}

		return false;
	}

	private boolean isPaswoardOk(User user) {

		if (user.getPass().equals(user.getPass2())) {
			return true;
		}
		return false;

	}
}
