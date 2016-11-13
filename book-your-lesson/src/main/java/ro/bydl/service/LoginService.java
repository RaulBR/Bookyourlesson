package ro.bydl.service;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.UserDAO;
import ro.bydl.domain.User;
import ro.bydl.service.errors.ValidationException;

/**
 * This class checks the validity of users and passeords
 * 
 * @author Raul
 *
 */

@Service
public final class LoginService {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);
	@Autowired
	private UserDAO dao;

	/**
	 * This method checks the validity of the User and returns the user.
	 * 
	 * @param user
	 * @return User
	 */
	public final User Permision(User user) throws ValidationException {
		// TODO
		List<String> errors = new LinkedList<String>();
		if (dao.getByUserAndPaswoard(user.getUser(), user.getPass()) != null) {
			user = dao.getByUserAndPaswoard(user.getUser(), user.getPass());
			user.setPass(null);

		} else {
			errors.add("user and/or pasword incorect");
		}
		if (!errors.isEmpty()) {
			throw new ValidationException(errors.toArray(new String[] {}));
		}

		return user;
	}

}
