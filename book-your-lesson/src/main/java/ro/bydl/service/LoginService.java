package ro.bydl.service;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.UserDAO;
import ro.bydl.domain.User;
import ro.bydl.exceptions.ValidationException;

/**
 * This class checks the validity of users and passwords
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
		PasswordHelper pasHelp = new PasswordHelper();

		List<String> errors = new LinkedList<String>();

		if (dao.getByUser(user.getUser()) != null
				&& pasHelp.authenticate(user.getPass().toCharArray(), dao.getByUser(user.getUser()).getPass())) {

			
			user = dao.getByUser(user.getUser());
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
