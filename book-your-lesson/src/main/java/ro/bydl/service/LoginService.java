package ro.bydl.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.database.JdbcTemplateUserDao;
import ro.bydl.domain.User;
/**
 * This class checks the validity of users and passeords
 * @author Raul
 *
 */

@Service
public final class LoginService  {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);
	@Autowired
	JdbcTemplateUserDao dao;

/**
 * This method checks the validity of the User and returns the user.
 * @param user
 * @return User
 */
	public final User Permision(User user) {
	
		for(User userFromDAO:dao.getAll()){
			if(userFromDAO.equals(user)){
				user.setId(userFromDAO.getId());
				user.setPermision(userFromDAO.getPermision());
				user.setStudentId(userFromDAO.getStudentId());
				user.setTeacherId(userFromDAO.getTeacherId());
				user.setUser(userFromDAO.getUser());
				
			}
			}
		return user;
	}

	
	
	

		
		
	}
	
	


